package com.ceiba.servicio.cliente;

import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.testdatabuilder.ClienteTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarClienteTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange
		Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();

		RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);

		Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);

		ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
		
		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,
				"El Cliente ya existe en el sistema");
	}
}
