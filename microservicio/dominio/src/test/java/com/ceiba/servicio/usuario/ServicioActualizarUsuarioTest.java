package com.ceiba.servicio.usuario;

import com.ceiba.modelo.entidad.Usuario;
import com.ceiba.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.testdatabuilder.UsuarioTestDataBuilder;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarUsuarioTest {

	@Test
	public void validarUsuarioExistenciaPreviaTest() {
		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();

		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

		Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);

		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,
				"El usuario ya existe en el sistema");
	}
}
