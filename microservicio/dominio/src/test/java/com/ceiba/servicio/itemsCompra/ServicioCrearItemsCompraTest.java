package com.ceiba.servicio.itemsCompra;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionExcesoItems;
import com.ceiba.dominio.excepcion.ExcepcionMaximoAnchoItem;
import com.ceiba.dominio.excepcion.ExcepcionMaximoLargoItem;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.testdatabuilder.DtoParametroTestDataBuilder;
import com.ceiba.testdatabuilder.ItemsTestDataBuilder;

public class ServicioCrearItemsCompraTest {

	@Test
	public void validarItemsCompraExistenciaPreviaTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().build();
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(true);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,
				"Estos Items de Compra ya existe en el sistema");
	}

	@Test
	public void validarCantidadSolicitadaTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conCantidad(15L).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("10").conEnum(EnumParametro.MAXIMO_ITEMS_POSIBLES).build());

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionExcesoItems.class,
				"Exceso en la cantidad de los items de compra");
	}

	@Test
	public void validarAnchoItemsCompraTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conAncho(8D).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any()))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_ANCHO_ITEM).build());

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionMaximoAnchoItem.class,
				"Exceso en el ancho del items de compra");
	}

	@Test
	public void validarLargoItemsCompraTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conLargo(8D).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);

		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.obtenerPorEnum(Mockito.any()))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.MAXIMO_LARGO_ITEM).build());

		ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra,
				daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionMaximoLargoItem.class,
				"Exceso en el largo del items de compra");
	}

}
