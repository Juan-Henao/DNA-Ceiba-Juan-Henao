package com.ceiba.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompra {
	
    private Long id;
	private DtoCliente idCliente;
    private Long total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;

}
