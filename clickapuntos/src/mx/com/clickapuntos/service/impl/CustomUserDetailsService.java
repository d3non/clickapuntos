package mx.com.clickapuntos.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import mx.com.clickapuntos.dao.impl.GenericDAO;
import mx.com.clickapuntos.dao.impl.UsuariosDAO;
import mx.com.clickapuntos.persistence.Usuariotipo;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
	private GenericDAO<Usuariotipo> usuariotipoDAO;
	public UsuariosDAO genericUsuarioDAO;
	
	@Inject
	public void setUsuariotipoDAO(GenericDAO<Usuariotipo> usuariotipoDAO) {
		this.usuariotipoDAO = usuariotipoDAO;
	}
	@Inject
	public void setGenericDAO(UsuariosDAO genericUsuarioDAO) {
		this.genericUsuarioDAO = genericUsuarioDAO;
	}
	public static UserDetails currentUserDetails(){
	    SecurityContext securityContext = SecurityContextHolder.getContext();
	    Authentication authentication = securityContext.getAuthentication();
	    if (authentication != null) {
	        Object principal = authentication.getPrincipal();
	        return  principal!=null? (UserDetails)principal : null;
	    }
	    return null;
	}
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			mx.com.clickapuntos.persistence.Usuarios Usuario = genericUsuarioDAO.findByUsremail(email).get(0);
			mx.com.clickapuntos.persistence.Usuariotipo usuarioTipo=usuariotipoDAO.findById(Integer.parseInt(String.valueOf(Usuario.getIdusuarios())));
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			System.out.println("Creando user");
			return new User(
					Usuario.getUsremail(), 
					Usuario.getPassword(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(usuarioTipo.getIdusuariotipo()));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
	 * @param role the numerical role
	 * @return a collection of {@link GrantedAuthority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * @param role the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 2) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");

		} else if (role.intValue() == 1) {
			roles.add("ROLE_USER");
		}

		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new GrantedAuthorityImpl(role));
		}
		return authorities;
	}
}
