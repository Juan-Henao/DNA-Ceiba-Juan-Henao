package com.ceiba.servicio.itemsCompra;

import java.math.BigDecimal;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;

public class ServicioCrearItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";
	private static final String EXCESO_ITEMS_COMPRA = "Exceso en la cantidad de los items de compra";
	private static final String SOBREPASO_ANCHO_ITEM = "Exceso en el ancho del items de compra";
	private static final String SOBREPASO_LARGO_ITEM = "Exceso en el largo del items de compra";
	private static final Double MAXIMO_ANCHO_ITEM = 4.0;
	private static final Double MAXIMO_LARGO_ITEM = 4.0;
	private static final Long MAXIMO_ITEMS_POSIBLES = 100l;

	private final RepositorioItemsCompra repositorioItemsCompra;

	public ServicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
	}

	public Long ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);
		validarCantidadSolicitada(itemsCompra);
		validarAnchoItemsCompra(itemsCompra);
		validarLargoItemsCompra(itemsCompra);

		return this.repositorioItemsCompra.crear(itemsCompra);
	}

	private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existe(itemsCompra.getFechaCreacion(),itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarCantidadSolicitada(ItemsCompra itemsCompra) {

		if (itemsCompra.getCantidad().compareTo(MAXIMO_ITEMS_POSIBLES) > BigDecimal.ZERO.intValue()) {
			throw new ExcepcionExcesoItems(EXCESO_ITEMS_COMPRA);
		}
	}

	private void validarAnchoItemsCompra(ItemsCompra itemsCompra) {
		if (itemsCompra.getAncho().compareTo(MAXIMO_ANCHO_ITEM) > BigDecimal.ZERO.intValue()) {
			throw new ExcepcionMaximoAnchoItem(SOBREPASO_ANCHO_ITEM);
		}
	}
	
	private void validarLargoItemsCompra(ItemsCompra itemsCompra) {
		if (itemsCompra.getLargo().compareTo(MAXIMO_LARGO_ITEM) > BigDecimal.ZERO.intValue()) {
			throw new ExcepcionMaximoLargoItem(SOBREPASO_LARGO_ITEM);
		}
	}
}
