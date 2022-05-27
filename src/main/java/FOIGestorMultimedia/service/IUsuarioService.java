package FOIGestorMultimedia.service;

import java.util.List;

import FOIGestorMultimedia.dto.Usuario;

public interface IUsuarioService {
	
	//Metodos del CRUD
	public List<Usuario> listarUsuario(); //Listar todo
	
	public Usuario guardarUsuario(Usuario usuario);	//Crear un Archivo
	
	public Usuario usuarioXNombre(String nombre); //Leer todos los datos de Archivo
	
	public Usuario actualizarUsuario(Usuario usuario); //Actualizar datos de Archivo
	
	public void eliminarUsuario(String nombre);// Eliminar Archivo


}