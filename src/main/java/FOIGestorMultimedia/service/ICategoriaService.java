package FOIGestorMultimedia.service;

import java.util.List;

import FOIGestorMultimedia.dto.Categoria;

public interface ICategoriaService {
	
	//Metodos del CRUD
	public List<Categoria> listarCategoria(); //Listar todo
	
	public Categoria guardarCategoria(Categoria categoria);	//Crear un Categoria
	
	public Categoria categoriaXID(int id); //Leer todos los datos de Categoria
	
	public Categoria actualizarCategoria(Categoria categoria); //Actualizar datos de Categoria
	
	public void eliminarCategoria(int id);// Eliminar Categoria


}