package com.ceiba.servicio.itemsCompra;

import java.math.BigDecimal;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;

public class ServicioActualizarItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";
	private static final String EXCESO_ITEMS_COMPRA = "Exceso en la cantidad de los items de compra";
	private static final String SOBREPASO_ANCHO_ITEM = "Exceso en el ancho del items de compra";
	private static final String SOBREPASO_LARGO_ITEM = "Exceso en el largo del items de compra";
	
	private final RepositorioItemsCompra repositorioItemsCompra;
	private final DaoParametro daoParametro;

	public ServicioActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra,DaoParametro daoParametro) {
		this.repositorioItemsCompra = repositorioItemsCompra;
		this.daoParametro = daoParametro;
	}

	public Long ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);
		validarCantidadSolicitada(itemsCompra);
		validarAnchoItemsCompra(itemsCompra);
		validarLargoItemsCompra(itemsCompra);
		return this.repositorioItemsCompra.crear(itemsCompra);
	}

	private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(),
				itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
	private void validarCantidadSolicitada(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(),
				itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
		if (itemsCompra.getCantidad().compareTo(Long.parseLong(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).getValor()))
				> BigDecimal.ZERO.intValue()) {
			throw new ExcepcionExcesoItems(EXCESO_ITEMS_COMPRA);
		}}
	}

	private void validarAnchoItemsCompra(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(),
				itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
		if (itemsCompra.getAncho().compareTo(Double.parseDouble(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).getValor()))
				> BigDecimal.ZERO.intValue()) {
			throw new ExcepcionMaximoAnchoItem(SOBREPASO_ANCHO_ITEM);
		}}
	}
	
	private void validarLargoItemsCompra(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(),
				itemsCompra.getFechaCreacion(), itemsCompra.getIdCompra());
		if (existe) {
		if (itemsCompra.getLargo().compareTo(Double.parseDouble(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).getValor()))
				> BigDecimal.ZERO.intValue()) {
			throw new ExcepcionMaximoLargoItem(SOBREPASO_LARGO_ITEM);
		}}
	}

}
