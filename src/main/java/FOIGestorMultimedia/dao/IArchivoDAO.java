package FOIGestorMultimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import FOIGestorMultimedia.dto.Archivo;
import FOIGestorMultimedia.dto.Usuario;

@EnableJpaRepositories
public interface IArchivoDAO extends JpaRepository<Archivo, Integer> {
//	Archivo findByCategoria(int id_categoria);
}