package com.ceiba.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.modelo.entidad.Compra;
import com.ceiba.modelo.util.EnumEstadoCompra;


public class CompraTestDataBuilder {


    private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private EnumEstadoCompra estadoCompra;
	
    public CompraTestDataBuilder() {
    	id = 1L;
    	idCliente = 1L;
    	total = 20000D;
    	fechaCompra = LocalDateTime.now();
    	fechaEntrega = fechaCompra.plusDays(6);
    	estadoCompra = EnumEstadoCompra.EN_PROCESO;
    	       
    }


    public CompraTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Compra build() {
        return new  Compra(id, idCliente, total, fechaCompra, fechaEntrega, estadoCompra);
        
    }
}