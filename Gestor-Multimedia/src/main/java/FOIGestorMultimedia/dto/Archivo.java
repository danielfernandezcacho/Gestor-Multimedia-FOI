package FOIGestorMultimedia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String tamanyo;
	private String path_publico;
	private String tipo;
	private String detalle;
	private String descripcion;
	private String id_categoria;
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
	 * @return the tamanyo
	 */
	public String getTamanyo() {
		return tamanyo;
	}
	/**
	 * @param tamanyo the tamanyo to set
	 */
	public void setTamanyo(String tamanyo) {
		this.tamanyo = tamanyo;
	}
	/**
	 * @return the path_publico
	 */
	public String getPath_publico() {
		return path_publico;
	}
	/**
	 * @param path_publico the path_publico to set
	 */
	public void setPath_publico(String path_publico) {
		this.path_publico = path_publico;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	 * @return the id_categoria
	 */
	public String getId_categoria() {
		return id_categoria;
	}
	/**
	 * @param id_categoria the id_categoria to set
	 */
	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
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
		return "Archivo [id=" + id + ", nombre=" + nombre + ", tamanyo=" + tamanyo + ", path_publico=" + path_publico
				+ ", tipo=" + tipo + ", detalle=" + detalle + ", descripcion=" + descripcion + ", id_categoria="
				+ id_categoria + ", nombre_usuario=" + nombre_usuario + "]";
	}
	
	
	
}