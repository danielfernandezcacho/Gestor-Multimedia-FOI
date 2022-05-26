package FOIGestorMultimedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FOIGestorMultimedia.dao.IUsuarioDAO;
import FOIGestorMultimedia.dto.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	IUsuarioDAO iProyectoDAO;

	@Override
	public List<Usuario> listarUsuario() {
		return IUsuarioDAO.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return IUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario usuarioXNombre(String nombre) {
		return IUsuarioDAO.findById(nombre).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return IUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(String nombre) {
		IUsuarioDAO.deleteById(nombre);
	}
	
}
