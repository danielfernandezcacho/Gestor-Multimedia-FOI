package FOIGestorMultimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import FOIGestorMultimedia.dto.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Integer> {

}