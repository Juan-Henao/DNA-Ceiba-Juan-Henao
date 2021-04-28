package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.modelo.entidad.ItemsCompra;

@Component
public class FabricaItemsCompra {

	public ItemsCompra crear(ComandoItemsCompra comandoItemsCompra) {
		return new ItemsCompra(comandoItemsCompra.getId(), comandoItemsCompra.getAncho(), comandoItemsCompra.getLargo(),
				comandoItemsCompra.getValor(), comandoItemsCompra.getCantidad(), comandoItemsCompra.getFechaCreacion(),
				comandoItemsCompra.getIdCompra());

	}

}
