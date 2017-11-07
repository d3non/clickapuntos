package mx.com.clickapuntos.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import mx.com.clickapuntos.bean.EnviadorMail;
import mx.com.clickapuntos.dao.AutentificacionDAOI;
import mx.com.clickapuntos.dao.CompaniaCelularDAOI;
import mx.com.clickapuntos.dao.EmailConfirmacionDAOI;
import mx.com.clickapuntos.dao.MensajeUsuariosDAOI;
import mx.com.clickapuntos.dao.ParametrosVigenciasDAOI;
import mx.com.clickapuntos.dao.impl.GenericDAO;
import mx.com.clickapuntos.dao.impl.UsuariosDAO;
import mx.com.clickapuntos.dao.impl.UsuariosdatosDAO;
import mx.com.clickapuntos.dao.impl.UsuariosdireccionesDAO;
import mx.com.clickapuntos.persistence.Autentificacion;
import mx.com.clickapuntos.persistence.CompaniaCelular;
import mx.com.clickapuntos.persistence.EmailConfirmacion;
import mx.com.clickapuntos.persistence.MensajeTipoUsuarioId;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.persistence.ParametrosVigencias;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.Usuariosdatos;
import mx.com.clickapuntos.persistence.Usuariosdirecciones;
import mx.com.clickapuntos.persistence.Usuariotipo;
import mx.com.clickapuntos.service.IUsuariosService;

import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements IUsuariosService{
	
	public UsuariosDAO genericUsuarioDAO;
	public AutentificacionDAOI autentificacionDAO;
	private UsuariosdatosDAO usuariosDatosDAO;
	private UsuariosdireccionesDAO usuariosDireccionesDAO;
	private EmailConfirmacionDAOI emailConfirmacionDAO;
	private GenericDAO<Usuariotipo> usuariotipoDAO;
	private MensajeUsuariosDAOI mensajeUsuariosDAO;
	private ParametrosVigenciasDAOI parametrosVigenciasDAO; 
	private CompaniaCelularDAOI companiaCelularDAO;
	
	@Inject
	public void setCompaniaCelularDAO(CompaniaCelularDAOI companiaCelularDAO) {
		this.companiaCelularDAO = companiaCelularDAO;
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
	public void setUsuariotipoDAO(GenericDAO<Usuariotipo> usuariotipoDAO) {
		this.usuariotipoDAO = usuariotipoDAO;
	}

	@Inject
	public void setEmailConfirmacionDAO(EmailConfirmacionDAOI emailConfirmacionDAO) {
		this.emailConfirmacionDAO = emailConfirmacionDAO;
	}

	@Inject
	public void setUsuariosDireccionesDAO(
			UsuariosdireccionesDAO usuariosDireccionesDAO) {
		this.usuariosDireccionesDAO = usuariosDireccionesDAO;
	}

	@Inject
	public void setUsuariosDatosDAO(UsuariosdatosDAO usuariosDatosDAO) {
		this.usuariosDatosDAO = usuariosDatosDAO;
	}

	@Inject
	public void setGenericDAO(UsuariosDAO genericUsuarioDAO) {
		this.genericUsuarioDAO = genericUsuarioDAO;
	}
	
	@Inject
	public void setAutentificacionDAO(AutentificacionDAOI autentificacionDAO) {
		this.autentificacionDAO = autentificacionDAO;
	}
		
	public void insertaUsuario(Usuarios usuarios){
		genericUsuarioDAO.save(usuarios);
		if(usuarios.getUsremail()!=null){
			if(!usuarios.getUsremail().equals("")){
				createMensaje(new Long("1"),usuarios);
			}
		}
	}
	public Usuarios InsertaOActualiza(Usuarios usuarios){
		Usuarios user=genericUsuarioDAO.findById(usuarios.getIdusuarios());
		if(user==null){
			long id=validaUsuarioP(usuarios.getUsridexterno(),usuarios.getProvider());
			if(id<0){
				insertaUsuario(usuarios);
				id=validaUsuarioP(usuarios.getUsridexterno(),usuarios.getProvider());
			}
			user=genericUsuarioDAO.findById(id);
		}
		return user;
			
		
	}
	public long validaUsuarioP(String idauxiliar,String provider){
		Long result=new Long("-1");
		List<Usuarios> lista=genericUsuarioDAO.findByIdAuxiliar(idauxiliar, provider);
		if(lista!=null ) {
			if(lista.size()>0 ) result=lista.get(0).getIdusuarios();
		}
		return result;
	}
	public boolean validaUsuario(String email){
		boolean valida = genericUsuarioDAO.findByProperty( 
				"usremail", email).size() > 0 ? true : false;
		return valida;
	}
	public boolean validaUsuario(String email,String password){
		boolean valida = genericUsuarioDAO.findByEmailPassword(email, password).size() > 0 ? true : false;
		return valida;
	}
	public Usuarios getUsuariosByEmail(String email){
		Usuarios user=null;
		List<Usuarios> listaUser=genericUsuarioDAO.findByProperty("usremail", email);
		if(listaUser!=null){
			if(listaUser.size()>0)
				user=listaUser.get(0);
		}
		return user;
	}
	
	public Usuarios getUsuariosByCelular(String celular){
		Usuarios user=null;
		List<Usuarios> listaUser=genericUsuarioDAO.findByProperty("usrcelular", celular);
		if(listaUser!=null){
			if(listaUser.size()>0)
				user=listaUser.get(0);
		}
		return user;
	}

	@Override
	public List<Autentificacion> getAutentificacionAll() {
		List<Autentificacion> lista=autentificacionDAO.findAll();
		return lista;
	}

	@Override
	public void actualizaUsuario(Usuarios usuarios) {
		genericUsuarioDAO.saveOrUpdate(usuarios);
	}

	@Override
	public boolean datosIncompletos(Usuarios usuarios) {
		boolean respuesta=false;
		if(usuarios.getUsremail()==null) respuesta=true;
		else if(usuarios.getUsremail().equals("")) respuesta=true;
		
		/*if(usuarios.getUsrfoto()==null) respuesta=true;
		else if(usuarios.getUsrfoto().equals("")) respuesta=true;*/
		
		if(usuarios.getUsrusername()==null) respuesta=true;
		else if(usuarios.getUsrusername().equals("")) respuesta=true;
		Usuariosdatos usuariosDatos= getUsuariosDatosByIdUser(Integer.parseInt(String.valueOf(usuarios.getIdusuarios())));
		if(usuariosDatos==null) respuesta=true;
		else{
			if(usuariosDatos.getUsrnombres()==null) respuesta=true;
			else if(usuariosDatos.getUsrnombres().equals("")) respuesta=true;
			
			if(usuariosDatos.getUsrapaterno()==null) respuesta=true;
			else if(usuariosDatos.getUsrapaterno().equals("")) respuesta=true;
		}
		Usuariosdirecciones usuariosDirecciones=getUsuariosDireccionesByIdUser(Integer.parseInt(String.valueOf(usuarios.getIdusuarios())));
		if(usuariosDirecciones==null) respuesta=true;
		else{
			/*if(usuariosDirecciones.getUdcalle()==null) respuesta=true;
			else if(usuariosDirecciones.getUdcalle().equals("")) respuesta=true;*/
			
			if(usuariosDirecciones.getUdcodigopostal()==null) respuesta=true;
			else if(usuariosDirecciones.getUdcodigopostal().equals("")) respuesta=true;
		}
		return respuesta;
	}

	@Override
	public Usuarios getUsuariosByIdUser(Long idUser) {
		Usuarios user = genericUsuarioDAO.findById(idUser);
		return user;
	}

	@Override
	public void SaveOrUpdate(Usuariosdatos usuariosDatos) {
		if(usuariosDatosDAO.findById(usuariosDatos.getIdusuarios())==null){
			usuariosDatosDAO.save(usuariosDatos);
		}
		else usuariosDatosDAO.attachDirty(usuariosDatos);
	}

	@Override
	public void SaveOrUpdateDirecciones(Usuariosdirecciones usuariosDirecciones) {
		if(usuariosDireccionesDAO.findById(usuariosDirecciones.getIdusuariosdirecciones())==null){
			usuariosDireccionesDAO.save(usuariosDirecciones);
		}
		else usuariosDireccionesDAO.attachDirty(usuariosDirecciones);
		
	}

	@Override
	public Usuariosdatos getUsuariosDatosByIdUser(Integer idUser) {
		return usuariosDatosDAO.findById(idUser);
	}

	@Override
	public Usuariosdirecciones getUsuariosDireccionesByIdUser(Integer idUser) {
		return usuariosDireccionesDAO.findById(idUser);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void enviaConfirmacion(Usuarios user,MensajeUsuarios mu) {
		List<EmailConfirmacion> lista=emailConfirmacionDAO.findAll();
		if(lista!=null){
			if(lista.size()>0){
				EnviadorMail enviadorMail = new EnviadorMail(user.getUsremail(),
						"Activacion cuenta", 
						"Hola " + user.getUsrusername()+", gracias por registrarte en Clickapuntos," 
						+ "Para activar tu cuenta necesitas ir al siguiente link: \n\n"
						+ lista.get(0).getPagina()+"?idUser="+user.getIdusuarios()+"&llaveclickapuntos="+mu.getMensaje()+"\n\n"
						+ "Equipo Clickapuntos",
						lista.get(0).getEmailEnvio(),
						lista.get(0).getPassword(),
						lista.get(0).getServidorsmtp(),
						lista.get(0).getPuerto());
			}
		}
	}

	@Override
	public Usuariotipo getUsuarioTipoById(Integer id) {
		return usuariotipoDAO.findById(id);
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
		if(idMensaje==0){
			MensajeTipoUsuarioId id=new MensajeTipoUsuarioId(idMensaje,new Long("1"),user.getIdusuarios());
			
			Timestamp tiempo=new Timestamp(new Date().getTime());
			long dias=10;
			ParametrosVigencias pv=getParametrosVigenciasByTipo(new Long("1"));
			if(pv!=null)
				if(pv.getNumDias()!=null)
					dias=pv.getNumDias();
			dias=(dias)*(1000*60*60*24);
			Timestamp vigencia=new Timestamp(new Date().getTime()+dias);
			String mensaje=getCadenaAlfanumAleatoria(10);
			MensajeUsuarios mu=new MensajeUsuarios(id,tiempo,null,tiempo,mensaje,vigencia,new Long("1"));
			createMensaje(mu);
			List<MensajeUsuarios> mus=mensajeUsuariosDAO.findByProperty("fechacreacion", tiempo);
			if(mus!=null){
				if(mus.size()>0)
					idMensaje=mus.get(0).getId().getIdMensaje();
			}
			enviaConfirmacion(user,mu);
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
	public MensajeUsuarios getMensajeById(Long id) {
		return mensajeUsuariosDAO.findById(id);
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
	public ParametrosVigencias getParametrosVigenciasByTipo(Long id) {
		List<ParametrosVigencias> pvs=parametrosVigenciasDAO.findByProperty("idTipoParametro", id);
		if(pvs!=null){
			if(pvs.size()>0)
				return pvs.get(0);
		}
		return null;
	}
	
	@Override
	public List<CompaniaCelular> getCompaniasAll() {
		return companiaCelularDAO.findAll();
	}
}
