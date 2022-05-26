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

import org.springframework.data.jpa.repository.JpaRepository;
import FOIGestorMultimedia.dto.Categoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl asignadoServiceImpl;

	@GetMapping("/")
	public List<Categoria> listarAsignados() {
		return CategoriaServiceImpl.listarAsignado();
	}

	@PostMapping("/")
	public Categoria salvarAsignado(@RequestBody Categoria Asignado) {

		return CategoriaServiceImpl.guardarAsignado(Categoria);
	}

	@GetMapping("/{id}")
	public Categoria asignadoXID(@PathVariable(name = "id") int id) {

		Categoria asignado_xid = new Categoria();

		asignado_xid = categoriaServiceImpl.asignadoXID(id);

		return asignado_xid;
	}

	@PutMapping("/{id}")
	public Categoria actualizarAsignado(@PathVariable(name = "id") int id, @RequestBody Categoria categoria) {

		Categoria asignado_seleccionado = new Categoria();
		Categoria asignado_actualizado = new Categoria();

		asignado_seleccionado = categoriaServiceImpl.asignadoXID(id);

		asignado_seleccionado.setCientifico(asignado.getCientifico());
		asignado_seleccionado.setProyecto(asignado.getcategoria());

		asignado_actualizado = categoriaServiceImpl.actualizarAsignado(asignado_seleccionado);

		return asignado_actualizado;
	}

	@DeleteMapping("/{id}")
	public void eliminarAsignado(@PathVariable(name = "id") int id) {
		categoriaServiceImpl.eliminarAsignado(id);
	}

}
