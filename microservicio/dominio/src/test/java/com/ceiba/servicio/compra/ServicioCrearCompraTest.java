package com.ceiba.servicio.compra;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioCompra;
import com.ceiba.testdatabuilder.CompraTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearCompraTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange

		Compra compra = new CompraTestDataBuilder().build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(),Mockito.anyLong())).thenReturn(true);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra,daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra),
								ExcepcionDuplicidad.class, 
								"la Compra ya existe en el sistema");
	}
}
