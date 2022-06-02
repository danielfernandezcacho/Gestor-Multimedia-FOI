package FOIGestorMultimedia.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import FOIGestorMultimedia.dao.IUsuarioDAO;
import FOIGestorMultimedia.dto.Usuario;
import FOIGestorMultimedia.dto.Rol;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService{
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	//Metodos CRUD
	
	@Override
	public List<Usuario> listarUsuario() {
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioXID(int id) {
		return iUsuarioDAO.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(int id) {
		iUsuarioDAO.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = iUsuarioDAO.findByNombre(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		if (usuario.isSuperusuario()) {
			
			roles.add(new SimpleGrantedAuthority(Rol.ROLE_ADMIN.toString()));
			roles.add(new SimpleGrantedAuthority(Rol.ROLE_USER.toString()));
			
		} else {
		
			roles.add(new SimpleGrantedAuthority(Rol.ROLE_USER.toString()));
			
		}
	    			
		return new User(usuario.getNombre(), usuario.getContrasenya(), roles);
	}
	
}
