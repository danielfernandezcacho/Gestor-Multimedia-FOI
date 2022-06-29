package FOIGestorMultimedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FOIGestorMultimedia.dto.Categoria;
import FOIGestorMultimedia.service.CategoriaServiceImpl;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;

	//and... para que el mismo usuario vea sus categorias
	//@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/")
	public List<Categoria> listarCategoria() {
		return categoriaServiceImpl.listarCategoria();
	}

	//@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PostMapping("/")
	public Categoria salvarCategoria(@RequestBody Categoria categoria) {

		return categoriaServiceImpl.guardarCategoria(categoria);
	}

	//@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@GetMapping("/{id}")
	public Categoria CategoriaXID(@PathVariable(name = "id") int id) {

		Categoria categoria_xid = new Categoria();

		categoria_xid = categoriaServiceImpl.categoriaXID(id);

		return categoria_xid ;
	}

	//	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@PutMapping("/{id}")
	public Categoria actualizarCategoria(@PathVariable(name = "id") int id, @RequestBody Categoria categoria) {

		Categoria categoria_seleccionado = new Categoria();
		Categoria categoria_actualizado = new Categoria();

		categoria_seleccionado = categoriaServiceImpl.categoriaXID(id);

		categoria_seleccionado.setNombre(categoria.getNombre());
		categoria_seleccionado.setDescripcion(categoria.getDescripcion());
		categoria_seleccionado.setSuperCategoria(categoria.getSuperCategoria());

		categoria_actualizado = categoriaServiceImpl.actualizarCategoria(categoria_seleccionado);

		return categoria_actualizado;
	}

	//	@PreAuthorize("hasAnyAuthority('USER','ADMIN')")
	@DeleteMapping("/{id}")
	public void eliminarCategoria(@PathVariable(name = "id") int id) {
		categoriaServiceImpl.eliminarCategoria(id);
	}

}
