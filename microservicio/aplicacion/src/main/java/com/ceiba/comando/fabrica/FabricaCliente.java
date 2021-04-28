package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoCliente;
import com.ceiba.modelo.entidad.Cliente;

@Component
public class FabricaCliente {

	public Cliente crear(ComandoCliente comandoCliente) {
		return new Cliente(comandoCliente.getId(),  comandoCliente.getNombres(),
				comandoCliente.getApellidos(), comandoCliente.getIdentificacion(), comandoCliente.getEmail(),
				comandoCliente.getFechaCreacion());

	}

}
