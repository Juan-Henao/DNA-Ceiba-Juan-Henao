package com.ceiba.servicio.itemsCompra;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.testdatabuilder.ItemsTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearItemsCompraTest {

	@Test
	public void validarItemsCompraExistenciaPreviaTest() {
		// arrange

		ItemsCompra itemsCompra = new ItemsTestDataBuilder().build();
		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

		Mockito.when(repositorioItemsCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(true);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		ServicioCrearItemsCompra servicioCrearRol = new ServicioCrearItemsCompra(repositorioItemsCompra,daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearRol.ejecutar(itemsCompra),
								ExcepcionDuplicidad.class, 
								"Estos Items de Compra ya existe en el sistema");
	}
}
