package com.ceiba.servicio.compra;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDiaFestivo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionHorarioLaboral;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoParametro;
import com.ceiba.puerto.repositorio.RepositorioCompra;
import com.ceiba.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.testdatabuilder.DtoParametroTestDataBuilder;

public class ServicioCrearCompraTest {

	@Test
	public void validarClienteExistenciaPreviaTest() {
		// arrange

		Compra compra = new CompraTestDataBuilder().build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(true);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class,
				"la Compra ya existe en el sistema");
	}

	@SuppressWarnings("serial")
	@Test
	public void verificarFinDeSemanaTest() {
		// arrange yyyy-MM-dd

		Compra compra = new CompraTestDataBuilder().conFechaCompra(LocalDateTime.now()).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);

		Mockito.when(daoParametro.listarPorEnum(EnumParametro.FESTIVOS)).thenReturn(new ArrayList<DtoParametro>() {
			{
				add(new DtoParametroTestDataBuilder()
						.conValor(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString())
						.conEnum(EnumParametro.FESTIVOS).build());
			}
		});

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDiaFestivo.class,
				"la Compra no se puede realizar ya que es Festivo");
	}
	
	@Test
	public void validarHorarioHabilTest() {
		// arrange

		Compra compra = new CompraTestDataBuilder().conFechaCompra(LocalDateTime.now()).build();
		RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

		Mockito.when(repositorioCompra.existe(Mockito.any(), Mockito.anyLong())).thenReturn(false);
		DaoParametro daoParametro = Mockito.mock(DaoParametro.class);


		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_ENTRADA))
				.thenReturn(new DtoParametroTestDataBuilder().conValor("5").conEnum(EnumParametro.HORA_ENTRADA).build());
		
		Mockito.when(daoParametro.obtenerPorEnum(EnumParametro.HORA_SALIDA))
		.thenReturn(new DtoParametroTestDataBuilder().conValor("20").conEnum(EnumParametro.HORA_ENTRADA).build());

		ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra, daoParametro);

		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionHorarioLaboral.class,
				"El horario de la compra no es valido");
	}

}
