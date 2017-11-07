package mx.com.clickapuntos.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import mx.com.clickapuntos.bean.ComentariosBean;
import mx.com.clickapuntos.bean.PremiosBean;
import mx.com.clickapuntos.bean.PromocionesBean;
import mx.com.clickapuntos.bean.Top5Bean;
import mx.com.clickapuntos.dao.impl.GenericDAO;
import mx.com.clickapuntos.persistence.Mediapropiedades;
import mx.com.clickapuntos.persistence.Mediausuario;
import mx.com.clickapuntos.persistence.MediausuarioId;
import mx.com.clickapuntos.persistence.Premios;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.service.IDetalleService;
import mx.com.clickapuntos.service.IMediaService;

import org.springframework.stereotype.Service;

/* ----------------------------------------------------------------------
* MediaService 1.0
* 
* Este software contiene informacion totalmente confidencial propiedad de Clickapuntos.
* Queda totalmente prohibido su uso o divulgacion en forma parcial o total y solamente
* podra ser utilizada de acuerdo a los terminos y estatutos que determine dicha empresa
*
* Diseño: ISC Diego A. Zarate Diaz
* diegoazd@hotmail.com
* Clickapuntos
*
* Construcción: Diego A. Zarate Diaz
* diegoazd@hotmail.com
* Clickapuntos
*
* Este clase es el servicio para la parte del Wireframe de Medias
*  
*
* Septiembre 2011
* ---------------------------------------------------------------------*/


@Service
public class DetalleService implements IDetalleService{
	
	private GenericDAO<Mediausuario> mediaUsuarioDAO;
	private GenericDAO<Promos> promosDAO;
	private GenericDAO<Mediapropiedades> mediaPropDAO;
	private GenericDAO<Premios> premiosDAO;
	private GenericDAO<ComentariosBean> comentariosDAO;
	
	String sql = "select idpromo,promoimagenvideo, promonombreurl," +
				"sum( mediausuarionumreproduccion) as numrep, promonumeropuntos, mediaurl," +
				"promodescripcion, idmedia, clientenombre, promotipomecanica_idpromotipomecanica, mediausuariolike "+
				"from promos p, media m, mediapromo mp, mediausuario mu, clientes c  "+
				"where p.idpromo = mp.promos_idpromo "+ 
				"and mp.media_idmedia = m.idmedia "+
				"and c.idcliente = p.clientes_idcliente "+
				"and mp.media_idmedia = mu.media_idmedia "+
				"and m.mediaidpadre=0  and p.promostatus = 1 group by p.idpromo "+
				"order by numrep desc limit 0,5";
	
	String sqlFiltro = "select mp.* from mediapropiedades mp, mediaclasificacion mc,"+
				"media m, mediapromo medp, promos p where "+
				"mc.mediapropiedades_idclasificacionads = mp.idclasificacionads "+
				"and m.idmedia = medp.media_idmedia and medp.promos_idpromo = p.idpromo "+
				"and p.promostatus = 1 group by mp.idclasificacionads "+
				"order by mp.mpdescripcion";
	
	@Inject
	public void setMediaUsuarioDAO(GenericDAO<Mediausuario> mediaUsuarioDAO) {
		this.mediaUsuarioDAO = mediaUsuarioDAO;
	}

	@Inject
	public void setPromosDAO(GenericDAO<Promos> promosDAO) {
		this.promosDAO = promosDAO;
	}

	@Inject
	public void setMediaPropDAO(GenericDAO<Mediapropiedades> mediaPropDAO) {
		this.mediaPropDAO = mediaPropDAO;
	}
	
	@Inject
	public void setPremiosDAO(GenericDAO<Premios> premiosDAO) {
		this.premiosDAO = premiosDAO;
	}

	@Override
	/*
	 * idMedia  Es el id de la el id de la Media
	 * tipoAccion Este valor es de uso interno.
	 * 
	 * Metodo que se encarga de guardar en mediaUsuario de acuerdo a las siguientes reglas:
	 * 

	 * 1.- Si da una reproduccion 2.- Si se hizo un clic 3.- Si le dio un like 4.- Si no le gusta
	 * 5.- Favoritos 6.-Ni gusta ni disgusta ya 7.- No favoritos 
	 * */

	
	/*
	 * Metodo con el cual se llena el Billboard del wireframe de campañas
	 * */
	public List<PromocionesBean> getPromos(){
		StringBuffer sb = new StringBuffer("select p.idpromo,m.idmedia,promoimagenvideo, ")
		.append("promonombreurl, mediaurl,promodescripcion, ")
		.append("pm.idpromotipomecanica, mediatipo_idmediatipo, promomecanica, clientenombre, promoimagen ")
		.append("from promos p, media m, mediapromo mp, promotipomecanica pm, ")
		.append("clientes c where p.idpromo = mp.promos_idpromo ")
		.append("and mp.media_idmedia = m.idmedia ") 
		.append("and p.promotipomecanica_idpromotipomecanica = pm.idpromotipomecanica ")
		.append("and c.idcliente = p.clientes_idcliente and promomecanicavalor >= 90 ")
		.append("and m.mediaidpadre=0 and p.promostatus = 1 ")
		.append("order by promomecanicavalor desc limit 0,4");
		
		List<?> promos = promosDAO.findBySQL(sb.toString());
	
		return  getBillBoard(promos);
	}
	
	@SuppressWarnings("unchecked")
	public List<Top5Bean> getTops(){
		List tops = null;		
		tops =promosDAO.findBySQL(sql);		
		List<Top5Bean> listaTops = convTop5(tops);
		return listaTops;
	}
	
	/*
	 * Metodo con el cual se llenan los filtros del wiregframe de campalas
	 * */
	public List<Mediapropiedades> getFiltrado(){
		List<Mediapropiedades> filtro = mediaPropDAO.findBySQLEnt(sqlFiltro);
		return filtro;
	}
	
	/*
	 * Metodo con el cual se consulta a la BD para obtener los premios que los clientes estan regalando
	 * */
	public List<PremiosBean> getPremios(){
		List<Premios> premios = premiosDAO.findByProperty("premiostatus", "1");
		List<PremiosBean> lista = armaPremios(premios);
		return lista;	
	}
	
	/*
	 * Metodo con el cual se consulta a la BD para obtener todas las promociones activas ordenadas por promomecanicavalor
	 * */
	public List<PromocionesBean> getListadoPrin(String filtros){
		StringBuffer sb = new StringBuffer("select p.idpromo,m.idmedia,promoimagenvideo, promonombreurl,") 
				.append("sum( mediausuarionumreproduccion) as numrep,")
				.append("promonumeropuntos, mediaurl,promodescripcion, ")
				.append("pm.idpromotipomecanica,mediausuariolike,mediatipo_idmediatipo, promomecanica, clientenombre ")
				.append("from promos p, media m, mediapromo mp, mediausuario mu, promotipomecanica pm, ") 
				.append("mediaclasificacion mc, mediapropiedades mprop, clientes c ")
				.append("where p.idpromo = mp.promos_idpromo ")
				.append("and mp.media_idmedia = m.idmedia ")
				.append("and mp.media_idmedia = mu.media_idmedia ")
				.append("and p.promotipomecanica_idpromotipomecanica = pm.idpromotipomecanica ")
				.append("and c.idcliente = p.clientes_idcliente ")
				.append("and mc. media_idmedia = m.idmedia ")
				.append("and mc.mediapropiedades_idclasificacionads = mprop.idclasificacionads ")
				.append("and m.mediaidpadre=0 and p.promostatus = 1 ");
		
				if(filtros != null && !filtros.equals("") ){					
					sb.append(" and mprop.idclasificacionads in(")
					.append(filtros)
					.append(") ");
				}		
				sb.append(" group by p.idpromo order by  promomecanicavalor,numrep desc");
				
		
		List<?> promos = promosDAO.findBySQL(sb.toString());
		return  getPromociones(promos);
	}
	
	/*
	 * Convierte de una lista Object[] a una lista List<PromocionesBean> para el Billboard
	 * */
	public List<PromocionesBean> getBillBoard(List<?> promos){
		Iterator<?> it = promos.iterator();
		List<PromocionesBean> lista = new ArrayList<PromocionesBean>();
		int i=0;
		while(it.hasNext()){
			Object[] top = (Object[]) it.next();
			PromocionesBean bean = new PromocionesBean();
			bean.setIdPromo((Integer)top[0]);
			bean.setIdMedia((Integer)top[1]);
			bean.setPromoImagenVideo((String)top[2]);
			bean.setPromoNombreUrl((String)top[3]);
			bean.setMediaUrl((String)top[4]);
			bean.setPromoDescripcion((String)top[5]);
			bean.setIdPromoTipoMecanica((Integer)top[6]);					
			bean.setIdMediaTipo((Integer)top[7]);
			bean.setPromoMecanica((String)top[8].toString());
			bean.setNumPromo(++i);
			bean.setNombreCliente((String)top[9].toString());
			bean.setPromoImagen((String)top[10].toString());
			lista.add(bean);
		}
		return lista;
	}
	
	/*
	 * Convierte de una lista Object[] a una lista List<PromocionesBean> para la parte de promociones
	 * */
	public List<PromocionesBean> getPromociones(List<?> promos){
		Iterator<?> it = promos.iterator();
		List<PromocionesBean> lista = new ArrayList<PromocionesBean>();
		int i=0;
		while(it.hasNext()){
			Object[] top = (Object[]) it.next();
			PromocionesBean bean = new PromocionesBean();
			bean.setIdPromo((Integer)top[0]);
			bean.setIdMedia((Integer)top[1]);
			bean.setPromoImagenVideo((String)top[2]);
			bean.setPromoNombreUrl((String)top[3]);
			bean.setNumrep(new BigDecimal(top[4].toString()).intValue());
			bean.setPromoNumeroPuntos((Integer)top[5]);
			bean.setMediaUrl((String)top[6]);
			bean.setPromoDescripcion((String)top[7]);
			bean.setIdPromoTipoMecanica((Integer)top[8]);
			bean.setMediaUsuarioLike((String)top[9].toString());		
			bean.setIdMediaTipo((Integer)top[10]);
			bean.setPromoMecanica((String)top[11].toString());
			bean.setNumPromo(++i);
			bean.setNombreCliente((String)top[12].toString());
			lista.add(bean);
		}
		return lista;
	}
	
	
	
//	public String getFiltros(List<Integer> filtros){
//		StringBuffer sb = new StringBuffer("");
//		for(Integer mp: filtros){
//			sb.append(mp)
//			.append(",");
//		}
//		
//		if(sb.toString().endsWith(",")){
//			sb = new StringBuffer(sb.substring(0, sb.length()-1));
//		}
//		
//		return sb.toString();
//	}
	
	/*
	 * Método que se encarga de convertir una lista List<Premios> a una lista List<PremiosBean>,
	 * esto con el fin de aplicar reglas de negocios para los premios 
	 * */
	public List<PremiosBean> armaPremios(List<Premios> premios){
		Integer cliAux=0;
		Integer numCli=0;
		Map<Integer, Integer> mapaClientes= new HashMap<Integer, Integer>();
		for(int i=0; i < premios.size(); i ++){
			Premios pr = premios.get(i);
			if(cliAux == pr.getClientes().getIdcliente()){
				mapaClientes.put(pr.getClientes().getIdcliente(),++numCli);
			}else{
				numCli=0;
				cliAux = pr.getClientes().getIdcliente();				
				mapaClientes.put(pr.getClientes().getIdcliente(),++numCli);
			}
		}
		List<PremiosBean> lista = new ArrayList<PremiosBean>();
		
		
		for(int i=0; i < premios.size(); i ++){
			Premios bean = premios.get(i);
			Integer tamCli = mapaClientes.get(bean.getClientes().getIdcliente());
			PremiosBean preBean = new PremiosBean();
			preBean.setNombreCliente(bean.getClientes().getClientenombre());
			preBean.setImgCliente(bean.getClientes().getClienteimagen());
			
			int j=0;
			for(j=0 ; j < tamCli; j++){				
				Premios auxPremios =premios.get(i+j);
				
				if(tamCli - 1 > 0 && tamCli - 1== j){
					preBean.setDescPremio(preBean.getDescPremio()+ " y ");
				}else if (j > 0){
					preBean.setDescPremio(preBean.getDescPremio()+ ",");
				}
				preBean.setDescPremio(preBean.getDescPremio()+auxPremios.getPremiocantidad()+ " " +
						auxPremios.getPremionombre());
				
			}
			lista.add(preBean);
			i= i + (j-1);
		}
		
		return lista;
	}
	
//	public List<Promos> get4Element(List<Promos> listPromos){
//		List<Promos> list4El = new ArrayList<Promos>();
//		int maxEl = 4;
//		if(listPromos.size() < 4){
//			maxEl = listPromos.size(); 
//		}
//		
//		for(int i=0; i < maxEl; i++){
//			list4El.add(listPromos.get(i));
//		}
//		return list4El;
//	}
	
	
	/*
	 * Convierte una lista generica en una lista List<Top5Bean> para elementos con Top5
	 * */
	public List<Top5Bean> convTop5(List<?> listaTop){
		Iterator<?> it = listaTop.iterator();
		List<Top5Bean> lista = new ArrayList<Top5Bean>();
		Integer i =1;
		while(it.hasNext()){
			Object[] top = (Object[]) it.next();
			Top5Bean bean = new Top5Bean();
			bean.setIdPromo((Integer)top[0]);
			bean.setPromoImagenVideo((String)top[1]);
			bean.setPromoNombreUrl((String)top[2]);
			bean.setNumRep(new BigDecimal(top[3].toString()).intValue());
			bean.setPuntos((Integer)top[4]);
			bean.setUrl((String)top[5]);
			bean.setPromoDesc((String)top[6]);
			bean.setTopNum("Top"+(++i));
			bean.setIdMedia((Integer)top[7]);
			bean.setNombreCliente((String)top[8]);
			bean.setIdPromoTipoMecanica((Integer)top[9]);
			bean.setMediaUsuarioLike((String)top[10].toString());
			lista.add(bean);
		}
		return lista;
	} 
	
	/*
	 * Metodo que se encarga de insertar en la tabla de mediaUsuario
	 * */
	public void insNuevaMedia(Integer idMedia,Integer idUsuario, Integer tipoAccion){
		MediausuarioId idMediaUs = new MediausuarioId();
		Mediausuario mediaUs = new Mediausuario();
		idMediaUs.setMediaIdmedia(idMedia);
		idMediaUs.setUsuariosIdusuarios(idUsuario);
		mediaUs.setId(idMediaUs);
		selAccion(tipoAccion, mediaUs);
		mediaUsuarioDAO.Save(mediaUs);		
	}
	
	/*
	 * Metodo que se encarga de actualizar en la tabla de mediaUsuario
	 * */
	public void actMediaUs(Integer idMedia,Integer idUsuario, Integer tipoAccion, 
			Mediausuario medUs){		
		actByAccion(tipoAccion, medUs);
		mediaUsuarioDAO.merge(medUs);
	}
	
	//TipoAccion 1.- Si da una reproduccion 2.- Si se hizo un clic 3.- Si le dio un like 4.- Si no le gusta
	//5.- Favoritos 6.-Ni gusta ni disgusta ya 7.- No favoritos
	public void selAccion(Integer tipoAccion, Mediausuario medUs){
		switch(tipoAccion){			
			case 1: 
				medUs.setMediausuarionumreproduccion(new Integer("1"));
				medUs.setMediausuarioclick(new Integer("0"));
				medUs.setMediausuariolike(new String("0"));
				medUs.setMediausuariofavoritos("0");
				break;
			case 2: 
				medUs.setMediausuarionumreproduccion(new Integer("0"));
				medUs.setMediausuarioclick(new Integer("1"));
				medUs.setMediausuariolike(new String("0"));
				medUs.setMediausuariofavoritos("0");
				break;
			case 3: 
				medUs.setMediausuarionumreproduccion(new Integer("0"));
				medUs.setMediausuarioclick(new Integer("0"));
				medUs.setMediausuariolike(new String("1"));
				medUs.setMediausuariofavoritos("0");
				break;
			case 4: 
				medUs.setMediausuarionumreproduccion(new Integer("0"));
				medUs.setMediausuarioclick(new Integer("0"));
				medUs.setMediausuariolike(new String("2"));
				medUs.setMediausuariofavoritos("0");
				break;	
			case 5: 
				medUs.setMediausuarionumreproduccion(new Integer("0"));
				medUs.setMediausuarioclick(new Integer("0"));
				medUs.setMediausuariolike(new String("0"));
				medUs.setMediausuariofavoritos("1");
				break;	
		}
	}

	//TipoAccion 1.- Si da una reproduccion 2.- Si se hizo un clic 3.- Si le dio un like 4.- Si no le gusta 
	//5.- Favoritos 6.-Ni gusta ni disgusta ya 7.- No favoritos
	public void actByAccion(Integer tipoAccion, Mediausuario medUs){
		switch(tipoAccion){			
		case 1: 
			int rep = medUs.getMediausuarionumreproduccion().intValue();
			medUs.setMediausuarionumreproduccion(++rep);
			break;
		case 2: 
			int clic = medUs.getMediausuarioclick().intValue();
			medUs.setMediausuarioclick(++clic);
			break;
		case 3: 
			if(medUs.getMediausuariolike().equals("1")){
				medUs.setMediausuariolike(new String("0"));
			}else{
				medUs.setMediausuariolike(new String("1"));
			}
			break;
		case 4: 
			medUs.setMediausuariolike(new String("2"));
			break;	
		case 5: 
			medUs.setMediausuariofavoritos("1");	
			break;	
		case 6: 
			medUs.setMediausuariolike(new String("0"));	
			break;
		case 7: 
			medUs.setMediausuariofavoritos("0");	
			break;	
	}
	}


	@Override
	public void insDetalleUs(Integer idMedia, Integer tipoAccion, Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insNuevaDeatlle(Integer idMedia, Integer idUsuario, Integer tipoAccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ComentariosBean> getComentarios(int idComentario) {

		List<ComentariosBean> lista = comentariosDAO.getComentarios(sqlFiltro);

		return lista;
		
	}
	

}
