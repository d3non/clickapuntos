package mx.com.clickapuntos.persistence;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class ComentarioPromoMediaUsuarioId implements java.io.Serializable {
	// Fields
		private Integer comentariosIdComentario;
		private Integer mediaIdmedia;
		private Integer promosIdpromo;
		private Long usuariosIdUsuario;
		
		@GeneratedValue(strategy = IDENTITY)
		@Column(name = "idcomentarios", nullable = false)
		public Integer getComentariosIdComentario() {
			return comentariosIdComentario;
		}
		public void setComentariosIdComentario(Integer comentariosIdComentario) {
			this.comentariosIdComentario = comentariosIdComentario;
		}
		
		@Column(name = "mediapromo_media_idmedia", nullable = false)
		public Integer getMediaIdmedia() {
			return mediaIdmedia;
		}
		public void setMediaIdmedia(Integer mediaIdmedia) {
			this.mediaIdmedia = mediaIdmedia;
		}
		
		@Column(name = "mediapromo_promos_idpromo", nullable = false)
		public Integer getPromosIdpromo() {
			return promosIdpromo;
		}
		public void setPromosIdpromo(Integer promosIdpromo) {
			this.promosIdpromo = promosIdpromo;
		}
		
		@Column(name = "usuarios_idusuarios", nullable = false)
		public Long getUsuariosIdUsuario() {
			return usuariosIdUsuario;
		}
		public void setUsuariosIdUsuario(Long usuariosIdUsuario) {
			this.usuariosIdUsuario = usuariosIdUsuario;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((comentariosIdComentario == null) ? 0
							: comentariosIdComentario.hashCode());
			result = prime * result
					+ ((mediaIdmedia == null) ? 0 : mediaIdmedia.hashCode());
			result = prime * result
					+ ((promosIdpromo == null) ? 0 : promosIdpromo.hashCode());
			result = prime
					* result
					+ ((usuariosIdUsuario == null) ? 0 : usuariosIdUsuario
							.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final ComentarioPromoMediaUsuarioId other = (ComentarioPromoMediaUsuarioId) obj;
			if (comentariosIdComentario == null) {
				if (other.comentariosIdComentario != null)
					return false;
			} else if (!comentariosIdComentario
					.equals(other.comentariosIdComentario))
				return false;
			if (mediaIdmedia == null) {
				if (other.mediaIdmedia != null)
					return false;
			} else if (!mediaIdmedia.equals(other.mediaIdmedia))
				return false;
			if (promosIdpromo == null) {
				if (other.promosIdpromo != null)
					return false;
			} else if (!promosIdpromo.equals(other.promosIdpromo))
				return false;
			if (usuariosIdUsuario == null) {
				if (other.usuariosIdUsuario != null)
					return false;
			} else if (!usuariosIdUsuario.equals(other.usuariosIdUsuario))
				return false;
			return true;
		}

		// Constructors
}
