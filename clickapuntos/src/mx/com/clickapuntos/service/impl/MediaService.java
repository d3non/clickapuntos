package mx.com.clickapuntos.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;

import mx.com.clickapuntos.bean.ComentariosBean;
import mx.com.clickapuntos.bean.PremiosBean;
import mx.com.clickapuntos.bean.PremiosUser;
import mx.com.clickapuntos.bean.PromocionesBean;
import mx.com.clickapuntos.bean.Top5Bean;
import mx.com.clickapuntos.dao.MensajeUsuariosDAOI;
import mx.com.clickapuntos.dao.ParametrosVigenciasDAOI;
import mx.com.clickapuntos.dao.PuntosDAOI;
import mx.com.clickapuntos.dao.PuntosUsrDAOI;
import mx.com.clickapuntos.dao.PuntosUsuarioDAOI;
import mx.com.clickapuntos.dao.PuntosUsuarioPremioDAOI;
import mx.com.clickapuntos.dao.TarjetasPremiosDAOI;
import mx.com.clickapuntos.dao.RutaImagenesDAOI;
import mx.com.clickapuntos.dao.impl.GenericDAO;
import mx.com.clickapuntos.dao.impl.UsuariosDAO;
import mx.com.clickapuntos.persistence.Comentarios;
import mx.com.clickapuntos.persistence.Mediapromo;
import mx.com.clickapuntos.persistence.Mediapropiedades;
import mx.com.clickapuntos.persistence.Mediausuario;
import mx.com.clickapuntos.persistence.MediausuarioId;
import mx.com.clickapuntos.persistence.MensajeTipoUsuarioId;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.persistence.ParametrosVigencias;
import mx.com.clickapuntos.persistence.Premios;
import mx.com.clickapuntos.persistence.PremiosUsuarioId;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.Promotipomecanica;
import mx.com.clickapuntos.persistence.PuntosUsr;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;
import mx.com.clickapuntos.persistence.PuntosUsuarios;
import mx.com.clickapuntos.persistence.PuntosUsuariosPromosId;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.TarjetasPremios;
import mx.com.clickapuntos.service.IMediaService;

import org.springframework.stereotype.Service;

import com.auronix.calixta.GatewayException;
import com.auronix.calixta.sms.SMSGateway;

import mx.com.clickapuntos.dao.impl.ComentariosDAO;

@Service
public class MediaService implements IMediaService{
	
	private GenericDAO<Mediausuario> mediaUsuarioDAO;
	private GenericDAO<Promos> promosDAO;
	private GenericDAO<Mediapropiedades> mediaPropDAO;
	private GenericDAO<Premios> premiosDAO;
	
	private UsuariosDAO genericUsuarioDAO;
	private PuntosUsrDAOI puntosUsrDAO;
	@SuppressWarnings("unused")
	private PuntosDAOI puntosDAO;
	private MensajeUsuariosDAOI mensajeUsuariosDAO;
	private PuntosUsuarioPremioDAOI puntosUsuarioPremioDAO;
	private PuntosUsuarioDAOI puntosUsuariosDAO;
	private TarjetasPremiosDAOI TarjetasPremiosDAO;

	private ComentariosDAO comentariosDAO;
	private GenericDAO<Promotipomecanica> promotipomecanicaDAO;
	private GenericDAO<Media> mediaDAO;
	private GenericDAO<Mediapromo> mediaPromoDAO;
	private ParametrosVigenciasDAOI parametrosVigenciasDAO; 
	private RutaImagenesDAOI rutaImagenesDAO; 
	
	
	

	String sql = "select idpromo, promoimagenvideo, promonombreurl," +
			"sum( mediausuarionumreproduccion) as numrep, promomaxpuntoscliente, mediaurl," +
			"promodescripcion, idmedia, clientenombre, promotipomecanica_idpromotipomecanica, mediausuariolike "+
			"from promos p, media m, mediapromo mp, mediausuario mu, clientes c  "+
			"where p.idpromo = mp.promos_idpromo "+ 
			"and mp.media_idmedia = m.idmedia "+
			"and c.idcliente = p.clientes_idcliente "+
			"and mp.media_idmedia = mu.media_idmedia "+
			"and m.mediaidpadre=0 and p.promostatus = 1 group by p.idpromo "+
			"order by promomaxpuntoscliente desc limit 0,5";
	
	
	
	@Inject
	public void setRutaImagenesDAO(RutaImagenesDAOI rutaImagenesDAO) {
		this.rutaImagenesDAO = rutaImagenesDAO;
	}

	@Inject
	public void setMediaPromoDAO(GenericDAO<Mediapromo> mediaPromoDAO) {
		this.mediaPromoDAO = mediaPromoDAO;
	}

	@Inject
	public void setParametrosVigenciasDAO(
			ParametrosVigenciasDAOI parametrosVigenciasDAO) {
		this.parametrosVigenciasDAO = parametrosVigenciasDAO;
	}
	
	@Inject
	public void setMensajeUsuariosDAO(MensajeUsuariosDAOI mensajeUsuariosDAO) {
		this.mensajeUsuariosDAO = mensajeUsuariosDAO;
	}

	@Inject
	public void setPuntosUsuarioPremioDAO(
			PuntosUsuarioPremioDAOI puntosUsuarioPremioDAO) {
		this.puntosUsuarioPremioDAO = puntosUsuarioPremioDAO;
	}
	
	@Inject
	public void setTarjetasPremiosDAO(
			TarjetasPremiosDAOI TarjetasPremiosDAO) {
		this.TarjetasPremiosDAO = TarjetasPremiosDAO;
	}

	@Inject
	public void setPuntosUsuariosDAO(PuntosUsuarioDAOI puntosUsuariosDAO) {
		this.puntosUsuariosDAO = puntosUsuariosDAO;
	}

	@Inject
	public void setPuntosDAO(PuntosDAOI puntosDAO) {
		this.puntosDAO = puntosDAO;
	}
	
	@Inject
	public void setMediaUsuarioDAO(GenericDAO<Mediausuario> mediaUsuarioDAO) {
		this.mediaUsuarioDAO = mediaUsuarioDAO;
	}
	@Inject
	public void setGenericUsuarioDAO(UsuariosDAO genericUsuarioDAO) {
		this.genericUsuarioDAO = genericUsuarioDAO;
	}
	
	@Inject
	public void setPuntosUsrDAO(PuntosUsrDAOI puntosUsrDAO) {
		this.puntosUsrDAO = puntosUsrDAO;
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
	@Inject
	public void setComentariosDAO(ComentariosDAO comentariosDAO) {
		this.comentariosDAO = comentariosDAO;
	}
	
	@Inject
	public void setPromotipomecanicaDAO(GenericDAO<Promotipomecanica> promotipomecanicaDAO) {
		this.promotipomecanicaDAO = promotipomecanicaDAO;
	}
	
	@Inject
	public void setMediaDAO(GenericDAO<Media> mediaDAO) {
		this.mediaDAO = mediaDAO;
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
	public void insMediaUs(Integer idMedia, Integer tipoAccion, Integer idUsuario){
	
		MediausuarioId idMediaUs = new MediausuarioId();
		idMediaUs.setMediaIdmedia(idMedia);
		idMediaUs.setUsuariosIdusuarios(idUsuario);
		Mediausuario mediaUsuario = mediaUsuarioDAO.findById(idMediaUs);
		if(mediaUsuario != null){
			actMediaUs(idMedia, idUsuario, tipoAccion, mediaUsuario);
		}else{
			mediaUsuario = new Mediausuario();
			mediaUsuario.setId(idMediaUs);			
			insNuevaMedia(idMedia, idUsuario, tipoAccion);
			
		}
	}
	
	/*
	 * 
	 * Metodo con el cual se llena el Billboard del wireframe de campañas
	 * 
	 * */
	
	public List<PromocionesBean> getPromos(){
		StringBuffer sb = new StringBuffer("select promos.idpromo, media.idmedia, promos.promoimagenvideo, ")
		.append("promos.promonombreurl, media.mediaurl, promos.promodescripcion, ")
		.append("promos.promotipomecanica_idpromotipomecanica, media.mediatipo_idmediatipo, promos.promomecanica, ")
		.append("clientes.clientenombre, promos.promoimagen ")
		.append("from clientes left join (promotipomecanica left join (promos left join( ")
		.append("mediapromo left join media on(media.idmedia=mediapromo.media_idmedia)) ") 
		.append("on(promos.idpromo=mediapromo.promos_idpromo)) ")
		.append("on(promos.promotipomecanica_idpromotipomecanica=promotipomecanica.idpromotipomecanica)) ")
		.append("on(promos.clientes_idcliente=clientes.idcliente) ")
		.append("where promotipomecanica.promomecanicavalor >= 90 and promos.promostatus = 1  ")
		.append("order by rand() desc limit 0,5;  ");
		
		List<?> promos = promosDAO.findBySQL(sb.toString());
		System.out.println(sb.toString());
		return  getBillBoard(promos);
	}

	/*
	 * 
	 * Metodo que resuelve el idpromo y id media para el controller en base al nombre de campaña
	 * 
	 * */
	
	public List<PromocionesBean> getIdpromomedia(String campaign){
		StringBuffer sb = new StringBuffer("select promos.idpromo, media.idmedia, promos.promoimagenvideo, ")
		.append("promos.promonombreurl, media.mediaurl, promos.promodescripcion, ")
		.append("promos.promotipomecanica_idpromotipomecanica, media.mediatipo_idmediatipo, promos.promomecanica, ")
		.append("clientes.clientenombre, promos.promoimagen ")
		.append("from clientes left join (promotipomecanica left join (promos left join( ")
		.append("mediapromo left join media on(media.idmedia=mediapromo.media_idmedia)) ") 
		.append("on(promos.idpromo=mediapromo.promos_idpromo)) ")
		.append("on(promos.promotipomecanica_idpromotipomecanica=promotipomecanica.idpromotipomecanica)) ")
		.append("on(promos.clientes_idcliente=clientes.idcliente) ")
		.append("where promos.promonombreurl = '")
		.append(campaign)
		.append("'");
		
		List<?> promos = promosDAO.findBySQL(sb.toString());
		System.out.println(sb.toString());
		return  getBillBoard(promos);
	}

	
	public List<Top5Bean> getTops(){
		@SuppressWarnings("rawtypes")
		List tops = null;		
		tops =promosDAO.findBySQL(sql);		
		List<Top5Bean> listaTops = convTop5(tops);
		return listaTops;
	}
	
	/*
	 * Metodo con el cual se llenan los filtros del wireframe de campañas
	 * */
	public List<Mediapropiedades> getFiltrado(){
		String sqlFiltro = "select mediapropiedades.idclasificacionads, concat(mediapropiedades.mpdescripcion, ' (',count(*), ')') as mpdescripcion  "+
				"from mediapropiedades "+ 
				"inner join(mediaclasificacion inner join(mediapromo inner join promos "+
				"on(mediapromo.promos_idpromo=promos.idpromo)) "+
				"on(mediapromo.media_idmedia=mediaclasificacion.media_idmedia)) "+
				"on(mediaclasificacion.mediapropiedades_idclasificacionads=mediapropiedades.idclasificacionads ) "+
				"where promos.promostatus=1 and promos.promotipomecanica_idpromotipomecanica < 4 "+
				"group by mediapropiedades.idclasificacionads order by count(*) desc";
		List<Mediapropiedades> filtro = mediaPropDAO.findBySQL(sqlFiltro);
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
	 * Opciones: 0=Todas las promociones activas, 
	 * 			 1=Todas las promociones activas regulares sección filtros 
	 * 			 2=Promociones con filtro clasificación
	 * 			 3=*/
	public List<PromocionesBean> getListadoPrin(int opcion, String filtros){
		StringBuffer sb = new StringBuffer("select promos.idpromo,media.idmedia,promos.promoimagenvideo, promos.promonombreurl, ") 
		.append(" sum( mediausuario.mediausuarionumreproduccion) as numrep,")
		.append(" promos.promomaxpuntoscliente, media.mediaurl, promos.promodescripcion, ")
		.append(" promos.promotipomecanica_idpromotipomecanica, mediausuario.mediausuariolike, ")
		.append(" media.mediatipo_idmediatipo, promos.promomecanica, clientes.clientenombre ") 
		.append(" from clientes left join(promotipomecanica left join(promos left join (mediausuario right join ")
		.append(" (mediapromo left join(media left join ")
		.append(" ( mediaclasificacion left join mediapropiedades ")
		.append(" on(mediapropiedades.idclasificacionads = mediaclasificacion.mediapropiedades_idclasificacionads)) ")
		.append(" on(mediaclasificacion.media_idmedia = media.idmedia)) ")
		.append(" on(media.idmedia = mediapromo.media_idmedia)) ")
		.append(" on(mediapromo.media_idmedia = mediausuario.media_idmedia)) ")
		.append(" on(mediapromo.promos_idpromo = promos.idpromo)) ")
		.append(" on(promos.promotipomecanica_idpromotipomecanica = promotipomecanica.idpromotipomecanica)) ")
		.append(" on(promos.clientes_idcliente = clientes.idcliente) ")
		.append(" where promos.promostatus = 1 ");

		if(opcion == 1 ){
			sb.append(" and promotipomecanica.promomecanicavalor < 90 ");
		}
		
		
		if(opcion == 2 ){
			sb.append(" and promotipomecanica.promomecanicavalor < 90 ");
			
			if(filtros != null && !filtros.equals("") ){
				sb.append(" and mediaclasificacion.mediapropiedades_idclasificacionads =")
				.append(filtros);
			}
		}

		if(opcion == 3)
			sb.append(" and (clientes.clientenombre like '%"+filtros+"%') or (promos.promonombreurl like '%"+filtros+"%') or (promos.promodescripcion like '%"+filtros+"%')");
		
		sb.append(" group by promos.idpromo order by promos.promomaxpuntoscliente desc");
		

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
			//bean.setPromomecanicalargo((String)top[11]);
			lista.add(bean);
		}
		return lista;
	}
	
	/*
	 * Convierte de una lista Object[] a una lista List<TarjetasPremios>
	 * */
	public List<TarjetasPremios> getTarjetasPremios(List<?> tarjetasPremios){
		Iterator<?> it = tarjetasPremios.iterator();
		List<TarjetasPremios> lista = new ArrayList<TarjetasPremios>();
		while(it.hasNext()){
			Object[] top = (Object[]) it.next();
			TarjetasPremios tar = new TarjetasPremios();
			long idTarjeta = (Integer)top[0];
			tar.setId(idTarjeta);
			tar.setCodigo((String)top[1]);
			tar.setTipoTarjeta((Integer)top[2]);
			tar.setMonto((Integer)top[3]);
			tar.setStatus((Integer)top[4]);
			tar.setFechaAlta((Timestamp)top[5]);
			tar.setFechaAsignacion((Timestamp)top[6]);
			tar.setIdTransaccion((Long)top[7]);
			lista.add(tar);
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
			if(top[0]!=null)bean.setIdPromo((Integer)top[0]);
			if(top[1]!=null) bean.setIdMedia((Integer)top[1]);
			if(top[2]!=null) bean.setPromoImagenVideo((String)top[2]);
			if(top[3]!=null) bean.setPromoNombreUrl((String)top[3]);
			if(top[4]!=null) bean.setNumrep(new BigDecimal(top[4].toString()).intValue());
			else bean.setNumrep(0);
			if(top[5]!=null) bean.setPromoNumeroPuntos((Integer)top[5]);
			if(top[6]!=null) bean.setMediaUrl((String)top[6]);
			if(top[7]!=null) bean.setPromoDescripcion((String)top[7]);
			if(top[8]!=null) bean.setIdPromoTipoMecanica((Integer)top[8]);
			if(top[9]!=null) bean.setMediaUsuarioLike((String)top[9].toString());		
			if(top[10]!=null) bean.setIdMediaTipo((Integer)top[10]);
			if(top[11]!=null) bean.setPromoMecanica((String)top[11].toString());
			 bean.setNumPromo(++i);
			if(top[12]!=null) bean.setNombreCliente((String)top[12].toString());
			 lista.add(bean);
		}
		return lista;
	}
	
	/*
	 * Convierte de una lista Object[] a una lista List<PremiosUser> para la parte de premios
	 * */
	public List<PremiosUser> getPremios(List<?> premios, long puntos){
		Iterator<?> it = premios.iterator();
		List<PremiosUser> lista = new ArrayList<PremiosUser>();
		int i=0;
		while(it.hasNext()){
			Object[] top = (Object[]) it.next();
			PremiosUser bean = new PremiosUser();
			if(top[0]!=null) bean.setIdPremio(String.valueOf(top[0]));
			if(top[1]!=null) bean.setImgCliente((String)top[1]);
			if(top[2]!=null) bean.setImgPremio((String)top[2]);
			if(top[3]!=null) bean.setNombreCliente((String)top[3]);
			if(top[4]!=null) bean.setNombrePremio((String)top[4]);
			if(top[5]!=null) bean.setIdTipoPremios(String.valueOf(top[5]));
			if(top[6]!=null) bean.setCantidad(String.valueOf(top[6]));
			if(top[7]!=null){
				long puntosF=(Integer)top[7]-puntos;
				if(puntosF>0) bean.setPuntosFaltantes(String.valueOf(puntosF));
				else bean.setPuntosFaltantes(null);
			}
			if(top[7]!=null) bean.setTotalPuntos(String.valueOf(top[7]));
			if(top[8]!=null) bean.setSku((String)top[8]);

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
	public void insNuevaMedia(Integer idMedia, Integer idUsuario, Integer tipoAccion){
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
	
	@SuppressWarnings("unchecked")
	public List<Comentarios> getComentarios(){
		List<Comentarios> lista = new ArrayList<Comentarios>();
		lista = comentariosDAO.findAll();
		return lista;	
	}
	@SuppressWarnings("unchecked")
	public List<ComentariosBean> getComentariosBean(Integer idPromo){
		List<Comentarios> lista = new ArrayList<Comentarios>();
		lista = comentariosDAO.findByIdPromo(idPromo);
		List<ComentariosBean> listaBean=new ArrayList<ComentariosBean>();
		List<Usuarios> users=genericUsuarioDAO.findAll();
		for(Comentarios comenta:lista){
			ComentariosBean cb=new ComentariosBean();
			cb.setIdcomentarios(comenta.getId().getComentariosIdComentario());
			cb.setComentariotono(comenta.getComentariotono());
			cb.setComentariostexto(comenta.getComentariostexto());
			cb.setFechacomentario(String.valueOf(comenta.getFechacomentario()));
			for(Usuarios user:users){
				if(user.getIdusuarios().equals(comenta.getId().getUsuariosIdUsuario())){
					cb.setUsername(user.getUsrusername());
					cb.setUsrfoto(user.getUsrfoto());
				}
			}
			listaBean.add(cb);
		}
		return listaBean;	
	}
	public List<Comentarios> getComentariosByIdPromo(Integer idPromo){
		List<Comentarios> lista = new ArrayList<Comentarios>();
		lista = comentariosDAO.findByIdPromo(idPromo);
		return lista;	
	}
	@SuppressWarnings("unchecked")
	public List<Usuarios> getUsuarios(){
		List<Usuarios> lista = new ArrayList<Usuarios>();
		lista = genericUsuarioDAO.findAll();
		return lista;	
	}
	/* (non-Javadoc)
	 * @see mx.com.clickapuntos.service.IMediaService#getTipoMecanica()
	 */
	@Override
	public List<Promotipomecanica> getTipoMecanica() {
		List<Promotipomecanica> listatipomecanica = new ArrayList<Promotipomecanica>();
		listatipomecanica = promotipomecanicaDAO.findAll();
		return listatipomecanica;	
	}

	/* (non-Javadoc)
	 * @see mx.com.clickapuntos.service.IMediaService#getPromosAll()
	 */
	@Override
	public List<Promos> getPromosAll() {		
		List<Promos> lista = new ArrayList<Promos>();
		lista = promosDAO.findAll();
		return lista;	
	}

	/* (non-Javadoc)
	 * @see mx.com.clickapuntos.service.IMediaService#getMediaAll()
	 */
	@Override
	public List<Media> getMediaAll() {
		List<Media> lista = new ArrayList<Media>();
		lista = mediaDAO.findAll();
		return lista;
	}
	
	@Override
	public Promos getPromosById(Integer idPromo) {
		Promos promos=promosDAO.findById(idPromo);
		return promos;
	}
	
	@Override
	public PuntosUsr getPuntosUsrByUserPromoId(Long idUser, Long idPromo) {
		List<PuntosUsr> puntosusr=puntosUsrDAO.findByUsrPromoId(idUser, idPromo);
		PuntosUsr pu=null;
		if(puntosusr!=null){
			if(puntosusr.size()>0) pu=puntosusr.get(0);
		}
		return pu;
	}
	@Override
	public Long insPuntosUsr(Long idUser, Integer idPromo, Integer idCliente,
			Long numPuntos) {
		PuntosUsuariosPromosId id=new PuntosUsuariosPromosId(idUser,idPromo,idCliente);
		PuntosUsr puntosUsr=new PuntosUsr();;
		puntosUsr.setId(id);
		puntosUsr.setFechacreacion(new Timestamp(new Date().getTime()));
		puntosUsr.setStatus("1");
		puntosUsr.setValor(numPuntos);
		long dias=(10)*(1000*60*60*24);
		puntosUsr.setVigencia(new java.sql.Date((new Date().getTime())+dias));
		puntosUsrDAO.create(puntosUsr);
		PuntosUsuarios pu=puntosUsuariosDAO.findById(idUser);
		if(pu==null){
			pu=new PuntosUsuarios(idUser,numPuntos,new Long("0"),
						numPuntos,puntosUsr.getFechacreacion());
			puntosUsuariosDAO.create(pu);
		}
		else{
			pu.setTotalPuntos(pu.getTotalPuntos()+numPuntos);
			pu.setPuntosDisponibles(pu.getPuntosDisponibles()+numPuntos);
			puntosUsuariosDAO.update(pu);
		}
		
		System.out.println("Guardo correctamente los puntos al usuario");
		return pu.getPuntosDisponibles();
	}
	
	@Override
	public void descuentaPuntosPromo(Integer idPromo){
		Promos promo=promosDAO.findById(idPromo);
		if(promo!=null){
				promo.setPromonumeropuntos(promo.getPromonumeropuntos()-promo.getMaxPuntos());
				//System.out.println("ESTATUS ANTES DEEEEEEEEEEEE-------->" + promo.getPromostatus());
				if(promo.getPromonumeropuntos()<=0 && !promo.getPromostatus().equals("2")){
					//System.out.println("ENTRA A DESCUENTA PUNTOS-------->");
					promo.setPromostatus("0");
				}
				promosDAO.merge(promo);
				
		}
	}
	
	@Override
	public void aumentaPuntosPromo(Integer idPromo){
		Promos promo=promosDAO.findById(idPromo);
		if(promo!=null){
				promo.setPromonumeropuntos(promo.getPromonumeropuntos()+promo.getMaxPuntos());
				//System.out.println("ESTATUS ANTES DE-------->" + promo.getPromostatus());
				if(promo.getPromostatus().equals("0")){
					promo.setPromostatus("1");
				}
				promosDAO.merge(promo);
				//System.out.println("DESPUES ANTES DE-------->" + promo.getPromostatus());
		}
	}
	
	@Override
	public List<PuntosUsr> getPuntosUsrByIdUser(Long idUser) {
		List<PuntosUsr> lista=puntosUsrDAO.findByProperty("id.idUsuarios", idUser);
		if(lista!=null){
			if(lista.size()>0){
				return lista;
			}
			else{
				return null;
			}
		}
		else return null;
	}

	/*	@Override
	public List<PremiosUser> getPremiosByStatus(long puntos) {
		List<Premios> premios = premiosDAO.findByPropertyOrder("premiostatus", "1", "tipopremios_idtipopremios");
		System.out.println("Total premios: " + premios.size());
		List<PremiosUser> pus=new ArrayList<PremiosUser>();
		for(Premios p:premios){
			PremiosUser pu=new PremiosUser();
			pu.setIdPremio(String.valueOf(p.getIdpremios()));
			pu.setImgCliente(p.getClientes().getClienteimagen());
			pu.setImgPremio(p.getPremiourlimg());
			pu.setNombreCliente(p.getClientes().getClientenombre());
			pu.setNombrePremio(p.getPremiodescripcion());
			pu.setIdTipoPremios(String.valueOf(p.getIdtipopremio()));
			pu.setCantidad(String.valueOf(p.getPremiocantidad()));
			long puntosF=p.getPremiopuntos()-puntos;
			if(puntosF>0) pu.setPuntosFaltantes(String.valueOf(puntosF));
			else pu.setPuntosFaltantes(null);
			pu.setTotalPuntos(String.valueOf(p.getPremiopuntos()));
			pus.add(pu);
		}
		return pus;
	}*/

	@Override
	public List<PremiosUser> getPremiosByStatus(long puntos, int idTipo, int idCelular) {
		StringBuffer sb = new StringBuffer(""); 
		if ( idTipo == 1 ){
			sb.append("select premios.idpremios, clientes.clienteimagen, premios.premiourlimg,")
			.append(" clientes.clientenombre, premios.premionombre, premios.tipopremios_idtipopremios, premios.premiocantidad,")
			.append(" premios.premiopuntos, recargasku.sku ")
			.append(" from premios, recargasku, clientes ")
			.append(" where premios.premiocantidad = recargasku.monto and premios.clientes_idcliente = clientes.idcliente")
			.append(" and premios.premiostatus = 1 and recargasku.idtelefonia = ")
			.append(idCelular)
			.append(" and premios.tipopremios_idtipopremios = ")
			.append(idTipo)
			.append(" order by premios.premiocantidad asc");
		}
		
		if ( idTipo == 2 ){
			sb.append("select premios.idpremios, clientes.clienteimagen, premios.premiourlimg,")
			.append(" clientes.clientenombre, premios.premionombre, premios.tipopremios_idtipopremios, premios.premiocantidad,")
			.append(" premios.premiopuntos, '0'")
			.append(" from premios, clientes ")
			.append(" where premios.clientes_idcliente = clientes.idcliente")
			.append(" and premios.premiostatus = 1 and premios.tipopremios_idtipopremios = ")
			.append(idTipo)
			.append(" order by premios.premiocantidad asc");
		}

		List<?> premios = promosDAO.findBySQL(sb.toString());
		return  getPremios(premios, puntos);
	}

	@Override
	public List<PremiosUser> getPremiosByStatus(int idPremio, int idCelular) {
		StringBuffer sb = new StringBuffer("select premios.idpremios, clientes.clienteimagen, premios.premiourlimg,") 
		.append(" clientes.clientenombre, premios.premionombre, premios.tipopremios_idtipopremios, premios.premiocantidad,")
		.append(" premios.premiopuntos, recargasku.sku ")
		.append(" from premios, recargasku, clientes ")
		.append(" where premios.premiocantidad = recargasku.monto and premios.idpremios = ")
		.append(idPremio)
		.append(" and premios.premiostatus = 1 and recargasku.idtelefonia = ")
		.append(idCelular);
		
		List<?> premios = promosDAO.findBySQL(sb.toString());
		return  getPremios(premios, 0);
	}

	@Override
	public List<TarjetasPremios> getTarjetasPremios(int tipoTarjeta, int monto) {
		StringBuffer sb = new StringBuffer("select idtarjeta, codigo, tipotarjeta, monto, status, fechaalta, fechaasignacion, idtransaccion")
		.append(" from tarjetaspremios where tipotarjeta = ")
		.append(tipoTarjeta) 
		.append(" and monto = ")
		.append(monto)
		.append(" and status = 0 order by fechaalta asc limit 1");
		
		List<?> tarjetas = promosDAO.findBySQL(sb.toString());
		return  getTarjetasPremios(tarjetas);
	}
	

	@Override
	public String getCadenaAlfanumAleatoria (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
			char c = (char)r.nextInt(255);
			if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
				cadenaAleatoria += c;
				i ++;
			}
		}
		return cadenaAleatoria;
	}
	
	@Override
	public Long createMensaje(Long idMensaje,Usuarios user) {
		if(idMensaje == 0){
			MensajeTipoUsuarioId id = new MensajeTipoUsuarioId(idMensaje,new Long("2"),user.getIdusuarios());
			Timestamp tiempo = new Timestamp(new Date().getTime());
			long dias = 10;
			ParametrosVigencias pv = getParametrosVigenciasByTipo(new Long("1"));
			if(pv != null)
				if(pv.getNumDias() != null)
					dias = pv.getNumDias();
			dias = (dias)*(1000*60*60*24);
			Timestamp vigencia = new Timestamp(new Date().getTime()+dias);
			String mensaje = getCadenaAlfanumAleatoria(5);
			MensajeUsuarios mu = new MensajeUsuarios(id, tiempo, null, tiempo, mensaje, vigencia, new Long("1"));
			
			createMensaje(mu);
			List<MensajeUsuarios> mus = mensajeUsuariosDAO.findByProperty("fechacreacion", tiempo);
			if(mus != null){
				if(mus.size() > 0)
					idMensaje = mus.get(0).getId().getIdMensaje();
			}
			enviaMensaje(user.getUsrcelular(),"Hola tu código de canje es: " 
			+ mensaje
			+ ", ingrésalo en la sección 'Centro de Canje' para recibir tu recarga.Equipo Clickapuntos");
		}else{
			MensajeUsuarios mu = mensajeUsuariosDAO.findById(idMensaje);
			if(mu != null){
				if(mu.getContador() != null){
					if(mu.getContador() <= 2){
						Timestamp tiempo = new Timestamp(new Date().getTime());
						String mensaje = getCadenaAlfanumAleatoria(5);
						mu.setContador(mu.getContador()+1);
						mu.setFechaenvio(tiempo);
						actualizaMensaje(mu);
						enviaMensaje(user.getUsrcelular(),"Hola " + user.getUsrusername() + " tu código de canje es: "
						+ mensaje
						+ ", ingrésalo en la sección 'Centro de Canje' para recibir tu recarga.Equipo Clickapuntos");
					}
				}
			}
			
		}
		
		return idMensaje;
	}

	@Override
	public void createMensaje(MensajeUsuarios mu) {
		mensajeUsuariosDAO.create(mu);
		
	}

	@Override
	public void actualizaMensaje(MensajeUsuarios mu) {
		mensajeUsuariosDAO.update(mu);
		
	}

	@Override
	public boolean enviaMensaje(String numCel, String mensaje) {
		 SMSGateway smsGateway;
	     smsGateway = new SMSGateway();
	     boolean res = false;
	        try{
	        	int resp = smsGateway.sendMessage(numCel, mensaje);
	            System.out.println("Respuesta de envio de SMS##################" + resp);   

	        }catch(GatewayException e){
	            e.printStackTrace();
	        }
	        
	    return res;
	}

	@Override
	public MensajeUsuarios getMensajeById(Long id) {
		return mensajeUsuariosDAO.findById(id);
	}

	@Override
	public Timestamp insPremioUsuario(Long idUsuarios, Long idPremio, Long idMensaje) {
		PremiosUsuarioId id = new PremiosUsuarioId(null, idUsuarios, idPremio);
		Timestamp tiempo = new Timestamp(new Date().getTime());
		id.setFechaCambioPuntos(tiempo);
		long dias = 10;
		ParametrosVigencias pv = getParametrosVigenciasByTipo(new Long("1"));
		if(pv != null)
			if(pv.getNumDias() != null)
				dias=pv.getNumDias();
		dias = (dias)*(1000*60*60*24);
		Timestamp vigencia = new Timestamp(new Date().getTime()+dias);
		PuntosUsuarioPremio pup = new PuntosUsuarioPremio(id, idMensaje, vigencia, null ,"1");
		puntosUsuarioPremioDAO.create(pup);
		return tiempo;
	}

	@Override
	public void actualizaPremioUsuario(Long idTransaccion, Long idUsuarios, Long idPremio,Timestamp tiempo,
			String status,Long puntos) {
		
		PremiosUsuarioId id = new PremiosUsuarioId(idTransaccion, idUsuarios, idPremio);
		id.setFechaCambioPuntos(tiempo);
		PuntosUsuarioPremio pups = puntosUsuarioPremioDAO.findById(id);
		if(pups != null){
			pups.setStatusCanje(status);
			Timestamp tiempo2 = new Timestamp(new Date().getTime());
			pups.setFechaRecogioPremio(tiempo2);
			puntosUsuarioPremioDAO.update(pups);
			PuntosUsuarios pu = getPuntosUsuarioById(idUsuarios);
			if(pu != null){
				pu.setPuntosDisponibles(pu.getPuntosDisponibles()-puntos);
				pu.setPuntosCanjeados(pu.getPuntosCanjeados()+puntos);
				puntosUsuariosDAO.update(pu);
			}
			
			Premios p = premiosDAO.findById(Integer.parseInt(String.valueOf(idPremio)));
			if(p != null){
				if(p.getIdtipopremio() != null){
					if(p.getIdtipopremio() == 3){
						p.setPremiocantidad(p.getPremiocantidad()-1);
						if(p.getPremiocantidad() <= 0){
							p.setPremiostatus("2");
						}
					}
					//En otro caso implementar servicio, ya sea de recargas electronicas o dinero
				}
				premiosDAO.merge(p);
			}
		}
		
	}
	
	@Override
	public void actualizaTarjetaPremio(TarjetasPremios tp, Long idTransaccion)
		{
			Timestamp fechaasignacion = new Timestamp(new Date().getTime());
			tp.setFechaAsignacion(fechaasignacion);
			tp.setStatus(1);
			tp.setIdTransaccion(idTransaccion);
			TarjetasPremiosDAO.update(tp);
		}

	@Override
	public List<PuntosUsuarioPremio> getPuntosUsuarioPremioById(Long idUsuario) {
		List<PuntosUsuarioPremio> lista = puntosUsuarioPremioDAO.findByUsrPremioId( idUsuario );
		return lista;
	}

	@Override
	
	public Premios getPremiosById(int idPremio) {
		Premios premio = premiosDAO.findById(idPremio);
		return premio;
	}

	@Override
	public PuntosUsuarios getPuntosUsuarioById(Long id) {
		PuntosUsuarios pu=puntosUsuariosDAO.findById(id);
		return pu;
	}
	
	@Override
	public ParametrosVigencias getParametrosVigenciasByTipo(Long id) {
		List<ParametrosVigencias> pvs=parametrosVigenciasDAO.findByProperty("idTipoParametro", id);
		if(pvs!=null){
			if(pvs.size()>0)
				return pvs.get(0);
		}
		return null;
	}
	
	@Override
	public List<MensajeUsuarios> getMensajeByIdUser(Long id) {
		List<MensajeUsuarios> mus=mensajeUsuariosDAO.findByProperty("id.idUusarios", Integer.parseInt(String.valueOf(id)));
		if(mus!=null){
			if(mus.size()>0){
				return mus;
			}
		}
		return null;
	}

	@Override
	public void SaveOrUpdateMediaUsuario(Integer idMedia, Integer idUsuario) {
		MediausuarioId id=new MediausuarioId(idUsuario,idMedia);
		Mediausuario mu=mediaUsuarioDAO.findById(id);
		if(mu!=null){
			mu.setMediausuarionumreproduccion(mu.getMediausuarionumreproduccion()+1);
			mediaUsuarioDAO.merge(mu);
		}
		else{
			mu=new Mediausuario();
			mu.setId(id);
			mu.setMediausuarioclick(1);
			mu.setMediausuariolike("1");
			mu.setMediausuariolike("1");
			mu.setMediausuarionumreproduccion(1);
			mediaUsuarioDAO.Save(mu);
		}
	}

	@Override
	public List<Mediapromo> getMediaPormoByIdPromo(Integer idPromo) {
		return mediaPromoDAO.findByProperty("id.promosIdpromo", idPromo);
	}

	@Override
	public List<RutasImagenes> getAllRutasImagenes() {
		return rutaImagenesDAO.findAll();
	}

	@Override
	public List<RutasImagenes> getAllByTipo(String tipo) {
		return rutaImagenesDAO.findByProperty("tipo", tipo);
	}

	@Override
	public List<Mediausuario> getMediaUsuarioByIdPromo(Integer idMedia) {
		List<Mediausuario> mus=mediaUsuarioDAO.findByProperty("id.mediaIdmedia", idMedia);
		return mus;
	}
	
	public List<PremiosUser> filtrarLista(List<PremiosUser> lista,String id){
		List<PremiosUser> nuevaLista=new ArrayList<PremiosUser>();
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getIdTipoPremios().equals(id)){
				int pos=0;
				while((pos<nuevaLista.size())&&(!nuevaLista.get(pos).getCantidad().equals(lista.get(i).getCantidad()))) pos++;
				if(pos==nuevaLista.size()){
					nuevaLista.add(lista.get(i));
				}
			}
		}
		return nuevaLista;
	}
	
}
