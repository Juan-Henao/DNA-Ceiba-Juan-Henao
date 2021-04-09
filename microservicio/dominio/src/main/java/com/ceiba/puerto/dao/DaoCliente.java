package com.ceiba.puerto.dao;

import com.ceiba.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar Clientes
     * @return los usuarios
     */
    List<DtoCliente> listar();
    
	/**
	 * Permite obtener un Cliente dado su id
	 * 
	 * @param id
	 * @return el paciente
	 */
	DtoCliente obtener(Long id);
	
}
