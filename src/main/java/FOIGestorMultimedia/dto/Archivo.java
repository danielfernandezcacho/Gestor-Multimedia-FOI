package FOIGestorMultimedia.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="archivo")
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String nombre;
	@NonNull
	private String tamanyo;
	@NonNull
	private String path_publico;
	@NonNull
	private String tipo;
	private String detalle;
	private String descripcion;
	
	@ManyToOne  (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@ManyToOne  (cascade = CascadeType.ALL)
	@JoinColumn(name = "nombre_usuario")
	private Usuario usuario;
	
	/**
	 * 
	 */
	public Archivo() {
		
	}
	/**
	 * @param id
	 * @param nombre
	 * @param tamanyo
	 * @param path_publico
	 * @param tipo
	 * @param detalle
	 * @param descripcion
	 * @param categoria
	 * @param usuario
	 */
	public Archivo(int id, String nombre, String tamanyo, String path_publico, String tipo, String detalle,
			String descripcion, Categoria categoria, Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.tamanyo = tamanyo;
		this.path_publico = path_publico;
		this.tipo = tipo;
		this.detalle = detalle;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.usuario = usuario;
	}
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
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	@Override
	public String toString() {
		return "Archivo [id=" + id + ", nombre=" + nombre + ", tamanyo=" + tamanyo + ", path_publico=" + path_publico
				+ ", tipo=" + tipo + ", detalle=" + detalle + ", descripcion=" + descripcion + ", categoria="
				+ categoria + ", usuario=" + usuario + "]";
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}