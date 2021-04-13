package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;

import java.util.List;

public interface DaoParametro {

	/**
	 * Permite listar paramteros
	 * 
	 * @return los usuarios
	 */
	List<DtoParametro> listar();
	
	/**
	 * Permite obtener un paramteros por su id
	 * 
	 * @param id
	 * @return el arametro
	 */
	DtoParametro obtener(Long id);
	
	/**
	 * 
	 * @param username
	 * @return el usuario
	 */
	DtoParametro obtenerPorEnum(EnumParametro enumParametro);
	
}
