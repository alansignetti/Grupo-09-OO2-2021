package com.unla.Grupo09OO22021ABM.services;

import java.util.List;
import java.util.Optional;

import com.unla.Grupo09OO22021ABM.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> listar();
	public Optional<Usuario> listarId(int id);
	public Usuario findByDni(long dni);
	public Usuario findByEmail(String email);
	public Usuario findByUsername(String username);
	public int save(Usuario u);
	public void delete (int id);
	public Usuario traerPorId(int id);

}
