package mx.com.clickapuntos.service;

import java.util.List;

import mx.com.clickapuntos.persistence.Autentificacion;
import mx.com.clickapuntos.persistence.CompaniaCelular;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.persistence.ParametrosVigencias;
import mx.com.clickapuntos.persistence.Usuarios;
import mx.com.clickapuntos.persistence.Usuariosdatos;
import mx.com.clickapuntos.persistence.Usuariosdirecciones;
import mx.com.clickapuntos.persistence.Usuariotipo;

public interface IUsuariosService {
	
	public void insertaUsuario(Usuarios usuarios);
	public boolean validaUsuario(String email);
	public Usuarios getUsuariosByEmail(String email);
	public Usuarios getUsuariosByCelular(String celular);
	public boolean validaUsuario(String email,String password);
	public long validaUsuarioP(String idauxiliar,String provider);
	public Usuarios InsertaOActualiza(Usuarios usuarios);
	public List<Autentificacion> getAutentificacionAll();
	public void actualizaUsuario(Usuarios usuarios);
	public boolean datosIncompletos(Usuarios usuarios);
	public Usuarios getUsuariosByIdUser(Long idUser);
	public void SaveOrUpdate(Usuariosdatos usuariosDatos);
	public void SaveOrUpdateDirecciones(Usuariosdirecciones usuariosDirecciones);
	public Usuariosdatos getUsuariosDatosByIdUser(Integer idUser);
	public Usuariosdirecciones getUsuariosDireccionesByIdUser(Integer idUser);
	public void enviaConfirmacion(Usuarios user,MensajeUsuarios mu);
	public Usuariotipo getUsuarioTipoById(Integer id);
	public Long createMensaje(Long idMensaje,Usuarios user);
	public MensajeUsuarios getMensajeById(Long id);
	public List<MensajeUsuarios> getMensajeByIdUser(Long id);
	public String getCadenaAlfanumAleatoria (int longitud);
	public void createMensaje(MensajeUsuarios mu);
	public void actualizaMensaje(MensajeUsuarios mu);
	public ParametrosVigencias getParametrosVigenciasByTipo(Long id);
	public List<CompaniaCelular> getCompaniasAll();
}
