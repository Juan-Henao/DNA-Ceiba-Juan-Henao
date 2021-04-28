package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoCompra;
import com.ceiba.modelo.entidad.Compra;

@Component
public class FabricaCompra {

	public Compra crear(ComandoCompra comandoCompra) {
		return new Compra(comandoCompra.getId(), comandoCompra.getIdCliente(), comandoCompra.getTotal(),
				comandoCompra.getFechaCompra(), comandoCompra.getFechaEntrega(),comandoCompra.getEstadoCompra());

	}

}
