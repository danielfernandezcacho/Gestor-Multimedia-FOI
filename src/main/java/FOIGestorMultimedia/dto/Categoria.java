package FOIGestorMultimedia.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String nombre;
	private String descripcion;
	
	@Column(name = "id_supercategoria")
	private int superCategoria;

	@ManyToOne
	@JoinColumn(name = "nombre_usuario")
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Archivo> archivo;
	
	
	
	/**
	 * 
	 */
	public Categoria() {
		
	}
	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param usuario
	 */
	public Categoria(int id, String nombre, String descripcion, int superCategoria, Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.superCategoria = superCategoria;
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
	 * @return the nombre_usuario
	 */
	
	/**
	 * @return the categoria
	 */
	public int getSuperCategoria() {
		return superCategoria;
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
	/**
	 * @param categoria the categoria to set
	 */
	public void setSuperCategoria(int superCategoria) {
		this.superCategoria = superCategoria;
	}
	/**
	 * @return the archivo
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Archivo")
	public List<Archivo> getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(List<Archivo> archivo) {
		this.archivo = archivo;
	}
	

	
	
}