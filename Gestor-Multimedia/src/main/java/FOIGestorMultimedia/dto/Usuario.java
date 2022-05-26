package FOIGestorMultimedia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nombre;
	private String contrasenya;
	private boolean superusuario;
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
	public boolean getSuperusuario() {
		return superusuario;
	}
	/**
	 * @param superusuario the superusuario to set
	 */
	public void setSuperusuario(boolean superusuario) {
		this.superusuario = superusuario;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenya=" + contrasenya + ", superusuario=" + superusuario + "]";
	}
	
	
	
}