/**
 * Gestor-Multimedia - FOIGestorMultimedia.controller - UsuarioController
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/")
	public List<Usuario> listarUsuario() {
		return usuarioServiceImpl.listarUsuario();
	}

	@PostMapping("/")
	public Usuario salvarUsuarios(@RequestBody Usuario usuario) {

		return usuarioServiceImpl.guardarUsuario(usuario);
	}

	@GetMapping("/{nombre}")
	public Usuario usuariosXnombre(@PathVariable(name = "nombre") String nombre) {

		Usuario usuario_xid = new Usuario();

		usuario_xid = usuarioServiceImpl.usuarioXNombre(nombre);

		return usuario_xid;
	}

	@PutMapping("/{nombre}")
	public Usuario actualizarUsuarios(@PathVariable(name = "nombre") String nombre, @RequestBody Usuario usuario) {

		Usuario usuario_seleccionado = new Usuario();
		Usuario usuario_actualizado = new Usuario();

		usuario_seleccionado = usuarioServiceImpl.usuarioXNombre(nombre);

		usuario_seleccionado.setNombre(usuario.getNombre());
		usuario_seleccionado.setContrasenya(usuario.getContrasenya());
		usuario_seleccionado.setSuperusuario(usuario.getSuperusuario());
		
		usuario_actualizado = usuarioServiceImpl.actualizarUsuario(usuario_seleccionado);

		return usuario_actualizado;
	}

	@DeleteMapping("/{nombre}")
	public void eliminarUsuarios(@PathVariable(name = "nombre") String nombre) {
		usuarioServiceImpl.eliminarUsuario(nombre);
	}
}
