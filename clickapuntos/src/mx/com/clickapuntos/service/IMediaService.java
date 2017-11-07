package mx.com.clickapuntos.service;

import java.sql.Timestamp;
import java.util.List;

import javax.print.attribute.standard.Media;

import mx.com.clickapuntos.bean.ComentariosBean;
import mx.com.clickapuntos.bean.PremiosBean;
import mx.com.clickapuntos.bean.PremiosUser;
import mx.com.clickapuntos.bean.PromocionesBean;
import mx.com.clickapuntos.bean.Top5Bean;
import mx.com.clickapuntos.persistence.Comentarios;
import mx.com.clickapuntos.persistence.Mediapromo;
import mx.com.clickapuntos.persistence.Mediapropiedades;
import mx.com.clickapuntos.persistence.Mediausuario;
import mx.com.clickapuntos.persistence.MensajeUsuarios;
import mx.com.clickapuntos.persistence.PremiosUsuarioId;
import mx.com.clickapuntos.persistence.ParametrosVigencias;
import mx.com.clickapuntos.persistence.Premios;
import mx.com.clickapuntos.persistence.Promos;
import mx.com.clickapuntos.persistence.Promotipomecanica;
import mx.com.clickapuntos.persistence.PuntosUsr;
import mx.com.clickapuntos.persistence.PuntosUsuarioPremio;
import mx.com.clickapuntos.persistence.PuntosUsuarios;
import mx.com.clickapuntos.persistence.RutasImagenes;
import mx.com.clickapuntos.persistence.TarjetasPremios;
import mx.com.clickapuntos.persistence.Usuarios;



public interface IMediaService {
	
	public void insMediaUs(Integer idMedia, Integer tipoAccion, Integer idUsuario);
	public void insNuevaMedia(Integer idMedia, Integer idUsuario, Integer tipoAccion);
	public List<PromocionesBean> getPromos();
	public List<Top5Bean> getTops();
	public List<Mediapropiedades> getFiltrado();
	public List<PremiosBean> getPremios();
	public List<PromocionesBean> getListadoPrin(int opcion, String filtros);
	public List<PromocionesBean> getIdpromomedia(String campaign);
	public List<Comentarios> getComentarios();
	public List<Promotipomecanica> getTipoMecanica();
	public List<Promos> getPromosAll();
	public List<Media> getMediaAll();
	public List<Usuarios> getUsuarios();
	public List<Comentarios> getComentariosByIdPromo(Integer idPromo);
	public List<ComentariosBean> getComentariosBean(Integer idPromo);
	public Promos getPromosById(Integer idPromo);
	public PuntosUsr getPuntosUsrByUserPromoId(Long idUser,Long idPromo);
	public Long insPuntosUsr(Long idUser,Integer idPromo,Integer idCliente,Long numPuntos);
	public List<PuntosUsr> getPuntosUsrByIdUser(Long idUser);
	public List<PremiosUser> getPremiosByStatus(long puntos, int idTipo, int idCelular);
	public List<PremiosUser> getPremiosByStatus(int idPremio, int idCelular);
	public Long createMensaje(Long idMensaje,Usuarios user);
	public boolean enviaMensaje(String numCel,String mensaje);
	public MensajeUsuarios getMensajeById(Long id);
	public List<MensajeUsuarios> getMensajeByIdUser(Long id);
	public Timestamp insPremioUsuario(Long idUsuarios,Long idPremio,Long idMensaje);
	public void actualizaPremioUsuario(Long idTransaccion, Long idUsuarios, Long idPremio,Timestamp tiempo,	String status,Long puntos);
	public void actualizaTarjetaPremio(TarjetasPremios tp, Long idTransaccion);
	public List<PuntosUsuarioPremio> getPuntosUsuarioPremioById(Long idUsuario);
	public String getCadenaAlfanumAleatoria (int longitud);
	public void createMensaje(MensajeUsuarios mu);
	public void actualizaMensaje(MensajeUsuarios mu);
	public Premios getPremiosById(int idPremio);
	public PuntosUsuarios getPuntosUsuarioById(Long id);
	public List<TarjetasPremios> getTarjetasPremios(int tipoTarjeta, int monto);
	public ParametrosVigencias getParametrosVigenciasByTipo(Long id);
	public void SaveOrUpdateMediaUsuario(Integer idMedia,Integer idUsuario);
	public List<Mediapromo> getMediaPormoByIdPromo(Integer idPromo);
	public List<RutasImagenes> getAllRutasImagenes();
	public List<RutasImagenes> getAllByTipo(String tipo);
	public void descuentaPuntosPromo(Integer idPromo);
	public void aumentaPuntosPromo(Integer idPromo);
	public List<Mediausuario> getMediaUsuarioByIdPromo(Integer idMedia);
	public List<PremiosUser> filtrarLista(List<PremiosUser> lista,String id);
}

