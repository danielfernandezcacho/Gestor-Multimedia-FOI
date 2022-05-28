package FOIGestorMultimedia.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@Column(name = "nombre")
	private String nombre;
	@NonNull
	private String contrasenya;
	@NonNull
	@Column(columnDefinition = "boolean default false")
	private boolean superusuario;
	
	@OneToMany
	@JoinColumn(name = "nombre_usuario")
	private List<Categoria> categoria;
	
	@OneToMany
	@JoinColumn(name = "nombre_usuario")
	private List<Archivo> archivo;
	
	/**
	 * 
	 */
	public Usuario() {
		
	}
	/**
	 * @param nombre
	 * @param contrasenya
	 * @param superusuario
	 */
	public Usuario(String nombre, String contrasenya, boolean superusuario) {
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.superusuario = superusuario;
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
	 * @return the contrasenya
	 */
	public String getContrasenya() {
		return contrasenya;
	}
	/**
	 * @param contrasenya the contrasenya to set
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	/**
	 * @return the superusuario
	 */
	public Boolean getSuperusuario() {
		return superusuario;
	}
	/**
	 * @param superusuario the superusuario to set
	 */
	public void setSuperusuario(Boolean superusuario) {
		this.superusuario = superusuario;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenya=" + contrasenya + ", superusuario=" + superusuario + "]";
	}
	/**
	 * @return the categoria
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Categoria")
	public List<Categoria> getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
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