package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoUsuario;

public interface DaoUsuario {

	/**
	 * Permite listar usuarios
	 * 
	 * @return los usuarios
	 */
	List<DtoUsuario> listar();
	
	/**
	 * Permite obtener un usuario por su id
	 * 
	 * @param id
	 * @return el usuario
	 */
	DtoUsuario obtener(Long id);
	
	/**
	 * 
	 * @param username
	 * @return el usuario
	 */
	DtoUsuario obtenerPorUsername(String username);
	
}
