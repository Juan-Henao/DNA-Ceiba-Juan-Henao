package com.ceiba.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Compra;

public interface RepositorioCompra {
	/**
	 * Permite crear una Compra
	 * 
	 * @param Compra
	 * @return el id generado
	 */
	Long crear(Compra Compra);

	/**
	 * Permite actualizar una Compra
	 * 
	 * @param Compra
	 */
	void actualizar(Compra Compra);

	/**
	 * Permite eliminar una Compra
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe una compra con la fecha de compra, cliente y cristales relacionados
	 * 
	 * @param fechaCompra
	 * @param idCliente
	 * @param idCristal
	 * @return si existe o no
	 */
	boolean existe(LocalDateTime fechaCompra, Long idCliente, Long idCristal);
	
	
	/**
	 * Permite validar si existe una compra con la fecha de compra, cliente y cristal relacionados
	 * 
	 * @param id
	 * @param fechaCompra
	 * @param idCliente
	 * @param idCristal
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, LocalDateTime fechaCompra, Long idCliente, Long idCristal);
	
	/**
	 * Permite contar cuantas citas existen por dia
	 * 
	 * @param fechaCompra
	 * @return cantidad de compras por dia
	 */
	Integer contarComprasPorDia(LocalDateTime fechaCompra);
}
