/**
 * 
 */
package FOIGestorMultimedia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import FOIGestorMultimedia.dto.Archivo;
import FOIGestorMultimedia.dto.Categoria;
import FOIGestorMultimedia.dto.Usuario;
import FOIGestorMultimedia.dao.IArchivoDAO;

/**
 * @author danif
 *
 */

@Service
public class ArchivoServiceImpl implements IArchivoService {

	@Autowired
	IArchivoDAO iArchivoDAO;

	@Override
	public List<Archivo> listarArchivo() {
		return iArchivoDAO.findAll();
	}

	@Override
	public Archivo guardarArchivo(MultipartFile file) throws Exception {
	     // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Categoria categoria = new Categoria();
        Usuario usuario = new Usuario();
       
        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Archivo dbFile = new Archivo(fileName,file.getContentType(), file.getBytes(),categoria,usuario);

            return iArchivoDAO.save(dbFile);
        } catch (IOException ex) {
            throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
	}

	@Override
	public Archivo archivoXID(int id) {
		return iArchivoDAO.findById(id).get();
	}

	/*
	 * @Override public void actualizarArchivo(MultipartFile file) { return
	 * iArchivoDAO.save(file); }
	 */

	@Override
	public void eliminarArchivo(int id) {
		iArchivoDAO.deleteById(id);

	}

}
