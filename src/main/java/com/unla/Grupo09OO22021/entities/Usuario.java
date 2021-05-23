package com.unla.Grupo09OO22021.entities;
import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="usuario")
public class Usuario {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idUsuario;
		
		@Column(name="username", unique=true, nullable=false, length=45)
		private String username;
		
		@Column(name="password", nullable=false, length=60)
		private String password;
		
		@Column(name="createdat")
		@CreationTimestamp
		private LocalDateTime createdAt;
		
		@Column(name="updatedat")
		@UpdateTimestamp
		private LocalDateTime updatedAt;
		


		public Usuario() {}
		
		
		public Usuario(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public Usuario(int idUsuario,String username, String password) {
			this.idUsuario = idUsuario;
			this.username = username;
			this.password = password;
		}


		public int getIdUsuario() {
			return idUsuario;
		}


		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
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
			this.password = password;
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
		
		
		
}
