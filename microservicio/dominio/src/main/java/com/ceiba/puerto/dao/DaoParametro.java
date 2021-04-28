package com.ceiba.puerto.dao;

import java.util.List;

import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;

public interface DaoParametro {

	/**
	 * Permite listar paramteros
	 * 
	 * @return los usuarios
	 */
	List<DtoParametro> listar();
		
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
