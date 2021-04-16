package com.ceiba.servicio.compra;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioCompra;
import com.ceiba.testdatabuilder.CompraTestDataBuilder;

public class ServicioActualizarCompraTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange
		Compra compra = new CompraTestDataBuilder().conId(1L).build();

		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(repositorioCompra.existeExcluyendoId(Mockito.anyLong(), Mockito.any(), Mockito.anyLong()))
				.thenReturn(true);

		ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(
				repositorioCompra, daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(compra), ExcepcionDuplicidad.class,
				"La Compra ya existe en el sistema");
	}

}
