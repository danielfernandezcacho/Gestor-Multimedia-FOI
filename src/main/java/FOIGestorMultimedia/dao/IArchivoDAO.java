package FOIGestorMultimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import FOIGestorMultimedia.dto.Archivo;

public interface IArchivoDAO extends JpaRepository<Archivo, Integer> {

}