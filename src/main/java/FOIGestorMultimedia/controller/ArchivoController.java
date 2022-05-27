/**
 * Gestor-Multimedia - FOIGestorMultimedia.controller - ArchivoController
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 26/05/2022
 */
package FOIGestorMultimedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FOIGestorMultimedia.dto.Archivo;
import FOIGestorMultimedia.service.ArchivoServiceImpl;

/**
 * ArchivoController.java
 *
 */
@RestController
@RequestMapping("/archivos")
public class ArchivoController {

	@Autowired
	ArchivoServiceImpl archivoServiceImpl;

	@GetMapping("/")
	public List<Archivo> listarArchivo() {
		return archivoServiceImpl.listarArchivo();
	}

	@PostMapping("/")
	public Archivo salvarArchivo(@RequestBody Archivo archivo) {

		return archivoServiceImpl.guardarArchivo(archivo);
	}

	@GetMapping("/{id}")
	public Archivo archivoXID(@PathVariable(name = "id") int id) {

		Archivo archivo_xid = new Archivo();

		archivo_xid = archivoServiceImpl.archivoXID(id);

		return archivo_xid;
	}

	@PutMapping("/{id}")
	public Archivo actualizarArchivo(@PathVariable(name = "id") int id, @RequestBody Archivo archivo) {

		Archivo archivo_seleccionado = new Archivo();
		Archivo archivo_actualizado = new Archivo();

		archivo_seleccionado = archivoServiceImpl.archivoXID(id);

		archivo_seleccionado.setNombre(archivo.getNombre());
		archivo_seleccionado.setTamanyo(archivo.getTamanyo());
		archivo_seleccionado.setTipo(archivo.getTipo());
		archivo_seleccionado.setDetalle(archivo.getDetalle());
		archivo_seleccionado.setDescripcion(archivo.getDescripcion());
		archivo_seleccionado.setCategoria(archivo.getCategoria());
		

		archivo_actualizado = archivoServiceImpl.actualizarArchivo(archivo_seleccionado);

		return archivo_actualizado;
	}

	@DeleteMapping("/{id}")
	public void eliminarArchivo(@PathVariable(name = "id") int id) {
		archivoServiceImpl.eliminarArchivo(id);
	}
}
