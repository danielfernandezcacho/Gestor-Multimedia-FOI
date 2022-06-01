package FOIGestorMultimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import FOIGestorMultimedia.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	Usuario findByNombre(String nombre);
}