
package com.ceiba.comando.manejador.itemscompra;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.servicio.itemsCompra.ServicioEliminarItemsCompra;


@Component
public class ManejadorEliminarItemsCompra implements ManejadorComando<Long> {

    private final ServicioEliminarItemsCompra ServicioEliminarItemsCompra;

    public ManejadorEliminarItemsCompra(ServicioEliminarItemsCompra ServicioEliminarItemsCompra) {
        this.ServicioEliminarItemsCompra = ServicioEliminarItemsCompra;
    }

    public void ejecutar(Long idRol) {
        this.ServicioEliminarItemsCompra.ejecutar(idRol);
    }
}
