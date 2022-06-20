package FOIGestorMultimedia.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import FOIGestorMultimedia.dto.Archivo;

public interface IArchivoService {
	
	//Metodos del CRUD
	public List<Archivo> listarArchivo(); //Listar todo
	
	public Archivo guardarArchivo(Archivo archivo);	//Crear un Archivo
	
	public Archivo archivoXID(int id); //Leer todos los datos de Archivo
	
	public Archivo actualizarArchivo(Archivo archivo); //Actualizar datos de Archivo
	
	public void eliminarArchivo(int id);// Eliminar Archivo


}