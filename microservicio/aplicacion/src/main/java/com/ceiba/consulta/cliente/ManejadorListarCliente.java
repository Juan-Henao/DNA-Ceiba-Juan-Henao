package com.ceiba.consulta.cliente;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.modelo.dto.DtoCliente;
import com.ceiba.puerto.dao.DaoCliente;

@Component
public class ManejadorListarCliente {

	private final DaoCliente daoCliente;

	public ManejadorListarCliente(DaoCliente daoCliente) {
		this.daoCliente = daoCliente;
	}

	public List<DtoCliente> ejecutar() {
		return this.daoCliente.listar();
	}
}
