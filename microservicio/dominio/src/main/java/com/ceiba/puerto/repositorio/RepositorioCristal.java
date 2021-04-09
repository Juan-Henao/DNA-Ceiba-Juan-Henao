package com.ceiba.puerto.repositorio;

import com.ceiba.modelo.entidad.ItemsCompra;

public interface RepositorioCristal {
	/**
	 * Permite crear un Cristal
	 * 
	 * @param Cristal
	 * @return el id generado
	 */
	Long crear(ItemsCompra Cristal);

	/**
	 * Permite actualizar un Cristal
	 * 
	 * @param Cristal
	 */
	void actualizar(ItemsCompra Cristal);

	/**
	 * Permite eliminar un Cristal
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe un Cristal con una identificacion
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existe(String identificacion);

	/**
	 * Permite validar si existe un Cristal con una identificacion excluyendo un id
	 * 
	 * @param identificacion
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, String identificacion);
}
