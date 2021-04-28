package com.ceiba.comando.manejador.compra;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.compra.ServicioEliminarCompra;


@Component
public class ManejadorEliminarCompra implements ManejadorComando<Long> {

    private final ServicioEliminarCompra servicioEliminarCompra;

    public ManejadorEliminarCompra(ServicioEliminarCompra servicioEliminarCompra) {
        this.servicioEliminarCompra = servicioEliminarCompra;
    }

    public void ejecutar(Long idCompra) {
        this.servicioEliminarCompra.ejecutar(idCompra);
    }
}
