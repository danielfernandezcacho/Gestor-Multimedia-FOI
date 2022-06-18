/**
ca * Gestor-Multimedia - FOIGestorMultimedia.controller - UsuarioController
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 27/05/2022
 */
package FOIGestorMultimedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FOIGestorMultimedia.dao.IUsuarioDAO;
import FOIGestorMultimedia.dto.Usuario;
import FOIGestorMultimedia.service.UsuarioServiceImpl;


/**
 * UsuarioController.java
 *
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	IUsuarioDAO iUsuarioDAO;

	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO = iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/")
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		usuario.setContrasenya(bCryptPasswordEncoder.encode(usuario.getContrasenya()));
		iUsuarioDAO.save(usuario);
		return usuario;
	}

	//@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/")
	public List<Usuario> listarUsuario() {
		return usuarioServiceImpl.listarUsuario();
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@GetMapping("/{id}")
	public Usuario usuariosXID(@PathVariable(name = "id") int id) {

		Usuario usuario_xid = new Usuario();

		usuario_xid = usuarioServiceImpl.usuarioXID(id);

		return usuario_xid;
	}
    
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PutMapping("/{id}")
	public Usuario actualizarUsuarios(@PathVariable(name = "id") int id, @RequestBody Usuario usuario) {

		Usuario usuario_seleccionado = new Usuario();
		Usuario usuario_actualizado = new Usuario();

		usuario_seleccionado = usuarioServiceImpl.usuarioXID(id);

		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setContrasenya(bCryptPasswordEncoder.encode(usuario.getContrasenya()));
		usuario_seleccionado.setRol(usuario.getRol());
		
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);

		return usuario_actualizado;
	}

	@PreAuthorize("hasAnyAuthority('ADMIN')")
	@DeleteMapping("/{id}")
	public void eliminarUsuarios(@PathVariable(name = "id") int id) {
		usuarioServiceImpl.eliminarUsuario(id);
	}
}
