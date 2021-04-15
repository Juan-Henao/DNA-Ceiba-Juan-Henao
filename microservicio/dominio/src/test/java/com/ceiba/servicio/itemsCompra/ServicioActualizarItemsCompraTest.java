package com.ceiba.servicio.itemsCompra;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.ItemsCompra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.testdatabuilder.ItemsTestDataBuilder;

public class ServicioActualizarItemsCompraTest {

	@Test
	public void validarItemsExistenciaPreviaTest() {
		// arrange
		ItemsCompra itemsCompra = new ItemsTestDataBuilder().conId(1L).build();

		RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);
		
		Mockito.when(repositorioItemsCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong())).thenReturn(true);

		ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra,daoParametro);
		
		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,
				"Estos Items de Compra ya existe en el sistema");
	}
}
