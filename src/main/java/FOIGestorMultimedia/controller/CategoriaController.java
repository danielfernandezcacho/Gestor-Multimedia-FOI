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


import FOIGestorMultimedia.dto.Categoria;
import FOIGestorMultimedia.service.CategoriaServiceImpl;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;

	@GetMapping("/")
	public List<Categoria> listarCategoria() {
		return categoriaServiceImpl.listarCategoria();
	}

	@PostMapping("/")
	public Categoria salvarCategoria(@RequestBody Categoria categoria) {

		return categoriaServiceImpl.guardarCategoria(categoria);
	}

	@GetMapping("/{id}")
	public Categoria CategoriaXID(@PathVariable(name = "id") int id) {

		Categoria categoria_xid = new Categoria();

		categoria_xid = categoriaServiceImpl.categoriaXID(id);

		return categoria_xid ;
	}

	@PutMapping("/{id}")
	public Categoria actualizarCategoria(@PathVariable(name = "id") int id, @RequestBody Categoria categoria) {

		Categoria Categoria_seleccionado = new Categoria();
		Categoria Categoria_actualizado = new Categoria();

		Categoria_seleccionado = categoriaServiceImpl.categoriaXID(id);

		Categoria_seleccionado.setNombre(categoria.getNombre());
		Categoria_seleccionado.setDescripcion(categoria.getDescripcion());
		Categoria_seleccionado.setSuperCategoria(categoria.getSuperCategoria());

		Categoria_actualizado = categoriaServiceImpl.actualizarCategoria(Categoria_seleccionado);

		return Categoria_actualizado;
	}

	@DeleteMapping("/{id}")
	public void eliminarCategoria(@PathVariable(name = "id") int id) {
		categoriaServiceImpl.eliminarCategoria(id);
	}

}
