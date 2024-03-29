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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import FOIGestorMultimedia.dto.Archivo;
import FOIGestorMultimedia.dto.Usuario;
import FOIGestorMultimedia.service.ArchivoServiceImpl;

/**
 * ArchivoController.java
 *
 */


@RestController
@RequestMapping("/archivo")
public class ArchivoController {

	@Autowired
	ArchivoServiceImpl archivoServiceImpl;

	//@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/")
	public List<Archivo> listarArchivo() {

		return archivoServiceImpl.listarArchivo();
	}

//	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PostMapping("/subir")
	public Archivo salvarArchivo(@RequestParam("file") MultipartFile files,@RequestParam("categoria") int idCategoria,@RequestParam("usuario") int idUsuario) throws Exception {
	
	        return archivoServiceImpl.guardarArchivo(files,idCategoria,idUsuario);
	}

	//@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/{id}")
	public Archivo archivoXID(@PathVariable(name = "id") int id) {

		Archivo archivo_xid = new Archivo();

		archivo_xid = archivoServiceImpl.archivoXID(id);

		return archivo_xid;
	}

/*	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
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
		// archivo_actualizado.setData(archivo.getData());

		archivo_actualizado = archivoServiceImpl.actualizarArchivo(archivo_seleccionado);

		return archivo_actualizado;
	}*/

	//@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@DeleteMapping("/{id}")
	public void eliminarArchivo(@PathVariable(name = "id") int id) {
		archivoServiceImpl.eliminarArchivo(id);
	}
	
	/*@GetMapping("/categoria/{id_categoria}")
	public Archivo archivoXIDCategoria(@PathVariable(name = "id_categoria") int id_categoria) {

		Archivo archivo_xIDCategoria = archivoServiceImpl.archivoXIDCategoria(id_categoria);


		return archivo_xIDCategoria;
	}*/
}
