package com.unla.Grupo09OO22021ABM.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	
	@Column(name="nombre", nullable=false, length=45)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=45)
	private String apellido;
	
	@Column(name="tipo_dni")
	private String tipo_dni;
	
	@Column(name="dni", unique=true, nullable=false)
	private long dni;
	
	@Column(name="email", unique=true, nullable=false, length=60)
	private String email;
	
	@Column(name="username", unique=true, nullable=false, length=45)
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name = "enabled", columnDefinition = "boolean default true")
	private boolean enabled;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perfil", nullable = false)
	private Perfil perfil;

	@Column(name = "createdat", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedat", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	public Usuario() {}

	public Usuario( String nombre, String apellido, String tipo_dni, long dni, String email,
			String username, String password, Perfil perfil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_dni = tipo_dni;
		this.dni = dni;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = true;
		this.perfil=perfil;
	}

	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTipo_dni() {
		return tipo_dni;
	}

	public void setTipo_dni(String tipo_dni) {
		this.tipo_dni = tipo_dni;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        this.password = pe.encode(password);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_dni="
				+ tipo_dni + ", dni=" + dni + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", perfil=" + perfil + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	

}
