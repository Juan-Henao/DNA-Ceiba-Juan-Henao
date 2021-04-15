package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

import com.ceiba.modelo.util.EnumEstadoCompra;

@Getter
@AllArgsConstructor
public class DtoCompra {
	
    private Long id;
	private DtoCliente idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private EnumEstadoCompra estadoCompra;


}
