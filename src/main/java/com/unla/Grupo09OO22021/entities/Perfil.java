//package com.unla.Grupo09OO22021.entities;
//import java.time.LocalDateTime;
////import java.util.HashSet;
////import java.util.Set;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
////import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
////import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//@Entity
//@Table(name="perfil")
//public class Perfil {
//
//
//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		private int idPerfil;
//		
//		@Column(name="tipoPerfil", unique=false, nullable=false, length=30)
//		private String tipoPerfil;
//		
//		@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
//		private Set<Usuario> usuarios = new HashSet<Usuario>();
//		
//		@Column(name="createdat")
//		@CreationTimestamp
//		private LocalDateTime createdAt;
//		
//		@Column(name="updatedat")
//		@UpdateTimestamp
//		private LocalDateTime updatedAt;
//		
//
//
//		public Perfil() {}
//
//
//		
//		public Perfil(int idPerfil,String tipoPerfil) {
//			super();
//			this.idPerfil = idPerfil;
//			this.tipoPerfil = tipoPerfil;
//		}
//
//
//
//		public int getIdPerfil() {
//			return idPerfil;
//		}
//
//
//
//		public void setIdPerfil(int idPerfil) {
//			this.idPerfil = idPerfil;
//		}
//
//
//
//		public String getTipoPerfil() {
//			return tipoPerfil;
//		}
//
//
//
//		public void setTipoPerfil(String tipoPerfil) {
//			this.tipoPerfil = tipoPerfil;
//		}
//
//
//
//		public Set<Usuario> getUsuarios() {
//			return usuarios;
//		}
//
//
//
//		public void setUsuarios(Set<Usuario> usuarios) {
//			this.usuarios = usuarios;
//		}
//
//
//
//		public LocalDateTime getCreatedAt() {
//			return createdAt;
//		}
//
//
//
//		public void setCreatedAt(LocalDateTime createdAt) {
//			this.createdAt = createdAt;
//		}
//
//
//
//		public LocalDateTime getUpdatedAt() {
//			return updatedAt;
//		}
//
//
//
//		public void setUpdatedAt(LocalDateTime updatedAt) {
//			this.updatedAt = updatedAt;
//		}
//		
//		
//		
//		
//		
//}
