package FOIGestorMultimedia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private String id_supercategoria;
	private String nombre_usuario;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the id_supercategoria
	 */
	public String getId_supercategoria() {
		return id_supercategoria;
	}
	/**
	 * @param id_supercategoria the id_supercategoria to set
	 */
	public void setId_supercategoria(String id_supercategoria) {
		this.id_supercategoria = id_supercategoria;
	}
	/**
	 * @return the nombre_usuario
	 */
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	/**
	 * @param nombre_usuario the nombre_usuario to set
	 */
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	@Override
	public String toString() {
		return "Caegoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", id_supercategoria="
				+ id_supercategoria + ", nombre_usuario=" + nombre_usuario + "]";
	}

	
	
}