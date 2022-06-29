package FOIGestorMultimedia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "archivo")
public class Archivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String nombre;
	@NonNull
	private String tipo;
	@Lob
	private byte[] data;
	@NonNull
	private int id_categoria;
	@NonNull
	private int id_usuario;

	//@ManyToOne
//	@JoinColumn(name = "id_categoria")
//	private Categoria categoria;
//	
//	@ManyToOne
//	@JoinColumn(name = "id_usuario")
//	private Usuario usuario;



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
	public Archivo(String nombre, String tipo, byte[] data, int idCat, int idUser) {

		this.nombre = nombre;
		this.tipo = tipo;
		this.data = data;
		this.id_categoria = idCat;
		this.id_usuario = idUser;
	}
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
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

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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
	 * // * @return the categoria //
	 */
//	public Categoria getCategoria() {
//		return categoria;
//	}
//	@Override
//	public String toString() {
//		return "Archivo [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo  + ", categoria="
//				+ categoria + ", usuario=" + usuario + "]";
//	}
//	/**
//	 * @param categoria the categoria to set
//	 */
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
//	/**
//	 * @return the usuario
//	 */
//	public Usuario getUsuario() {
//		return usuario;
//	}
//	/**
//	 * @param usuario the usuario to set
//	 */
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}

}