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
	 * @param enumParametro
	 * @return el DtoParametro
	 */
	DtoParametro obtenerPorEnum(EnumParametro enumParametro);
	
	/**
	 * Permite listar paramteros dado su enum
	 * 
	 * @return los usuarios
	 */
	List<DtoParametro> listarPorEnum(EnumParametro enumParametro);
	
}
