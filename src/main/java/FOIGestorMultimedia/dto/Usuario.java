package FOIGestorMultimedia.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="usuario")
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(name = "nombre", unique= true)
	private String nombre;
	@NonNull
	private String contrasenya;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Categoria> categoria;
	
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private List<Archivo> archivo;
	
	@Enumerated(EnumType.STRING)
	public Rol rol;
	
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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contrasenya=" + contrasenya + "]";
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
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Archivo")
//	public List<Archivo> getArchivo() {
//		return archivo;
//	}
//	/**
//	 * @param archivo the archivo to set
//	 */
//	public void setArchivo(List<Archivo> archivo) {
//		this.archivo = archivo;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.toString()));
        return roles;
	}
	@Override
	public String getPassword() {
		return getContrasenya();
	}
	@Override
	public String getUsername() {
		return getNombre();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	/**
	 * @return the role
	 */
	public Rol getRol() {
		return rol;
	}
	/**
	 * @param role the role to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	
}