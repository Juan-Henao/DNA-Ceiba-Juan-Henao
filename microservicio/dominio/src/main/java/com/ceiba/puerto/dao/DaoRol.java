package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoRol;

public interface DaoRol {

	/**
	 * Permite listar roles
	 * 
	 * @return los roles
	 */
	List<DtoRol> listar();
	
	/**
	 * Permite obtener un rol por su id
	 * 
	 * @param id
	 * @return el usuario
	 */
	DtoRol obtener(Long id);
	
	/**
	 * 
	 * @param nombre_rol
	 * @return el usuario
	 */
	DtoRol obtenerPorNombreRol(String nombre_rol);
	
}
