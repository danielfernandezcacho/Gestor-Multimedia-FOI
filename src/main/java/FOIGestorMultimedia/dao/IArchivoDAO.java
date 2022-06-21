package FOIGestorMultimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import FOIGestorMultimedia.dto.Archivo;


public interface IArchivoDAO extends JpaRepository<Archivo, Integer> {

}