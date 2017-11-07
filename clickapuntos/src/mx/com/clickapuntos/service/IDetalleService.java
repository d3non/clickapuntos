package mx.com.clickapuntos.service;

import java.util.List;

import mx.com.clickapuntos.bean.ComentariosBean;
import mx.com.clickapuntos.bean.PremiosBean;
import mx.com.clickapuntos.bean.PromocionesBean;
import mx.com.clickapuntos.bean.Top5Bean;
import mx.com.clickapuntos.persistence.Mediapropiedades;
import mx.com.clickapuntos.persistence.Promos;



public interface IDetalleService {
	
	public void insDetalleUs(Integer idMedia, Integer tipoAccion,Integer idUsuario);
	public void insNuevaDeatlle(Integer idMedia, Integer idUsuario, Integer tipoAccion);
	public List<PromocionesBean> getPromos();
	public List<Top5Bean> getTops();
	public List<PremiosBean> getPremios();
	public List<PromocionesBean> getListadoPrin(String filtros);
	public List<ComentariosBean> getComentarios(int IdComentario);
}
