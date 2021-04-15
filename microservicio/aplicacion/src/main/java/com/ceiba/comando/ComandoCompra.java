package com.ceiba.comando;


import java.time.LocalDateTime;

import com.ceiba.modelo.util.EnumEstadoCompra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCompra{

    private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;
	private EnumEstadoCompra estadoCompra;

}
