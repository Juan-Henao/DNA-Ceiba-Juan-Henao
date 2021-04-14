package com.ceiba.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.comando.ComandoCompra;

public class ComandoCompraTestDataBuilder {

	private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;

	public ComandoCompraTestDataBuilder() {

		idCliente = 2L;
		total = 250000D;
		fechaCompra = LocalDateTime.now();
		fechaEntrega = LocalDateTime.now().plusDays(6);
	}

	public ComandoCompra build() {
		return new ComandoCompra(id, idCliente, total, fechaCompra, fechaEntrega);
	}
}
