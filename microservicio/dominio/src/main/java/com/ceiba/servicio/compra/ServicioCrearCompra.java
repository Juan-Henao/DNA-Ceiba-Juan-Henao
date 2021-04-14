package com.ceiba.servicio.compra;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionDiaFestivo;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.repositorio.RepositorioCompra;

public class ServicioCrearCompra {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "la Compra ya existe en el sistema";
	private static final String LA_COMPRA_NO_SE_REALIZA_FESTIVO = "la Compra no se puede realizar ya que es Festivo";
	private static final Double LA_COMPRA_ES_CERO = 0.0 ;
	private static final Double RECARGO_FIN_DE_SEMANA = 0.10 ;
	private static final int HORA_ENTRADA = 8 ;
	private static final int HORA_SALIDA = 8 ;
	private static final int DIAS_MINIMOS_FECHA_COMPRA = 5;
	private static final int DIAS_MAXIMOS_FECHA_COMPRA = 8;
	private static final int CONSTANTE_NUMERICA = 1;


	private final RepositorioCompra repositorioCompra;

	public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}

	public Long ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);
	
		//validarDiaFestivo(compra, null);
		validarHorarioHabil(compra);
		if (verificarFinDeSemana(compra)) {
			asignarRecargoFinDeSemana(compra);
		}
		asignarFechaEntrega(compra);
		return this.repositorioCompra.crear(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(), compra.getIdCliente());
		if(existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private boolean verificarFinDeSemana(Compra compra) {

		Calendar fechaCompraCalendar = Calendar.getInstance();
		fechaCompraCalendar.setTime(Date.from(compra.getFechaCompra().toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		return fechaCompraCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || fechaCompraCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ;

	}

	private void asignarRecargoFinDeSemana(Compra compra) {
		if ( compra.getTotal().equals(LA_COMPRA_ES_CERO)) {
			compra.setTotal(compra.getTotal() + (compra.getTotal() * RECARGO_FIN_DE_SEMANA));
		}

	}

	private void validarDiaFestivo(Compra compra , List<DtoParametro> ListDtoParametro) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		for (DtoParametro dtoParametro : ListDtoParametro) {
			if(compra.getFechaCompra().toLocalDate().isEqual(LocalDate.parse(dtoParametro.getValor(), formatter))) {
				throw new ExcepcionDiaFestivo(LA_COMPRA_NO_SE_REALIZA_FESTIVO);
			}
		}
	}

	private void validarHorarioHabil(Compra compra ) {

		if(compra.getFechaCompra().getHour() < HORA_ENTRADA || compra.getFechaCompra().getHour() > HORA_SALIDA ){
			throw new ExcepcionDiaFestivo(LA_COMPRA_NO_SE_REALIZA_FESTIVO);
		}
	}

	private void asignarFechaEntrega(Compra compra) {
		int cantidadDias = obtenerDiasFechaEntrega();
		compra.setFechaEntrega(compra.getFechaCompra().plusDays(cantidadDias));
	}

	private int obtenerDiasFechaEntrega() {
		return (int)Math.floor(Math.random()*(DIAS_MAXIMOS_FECHA_COMPRA-DIAS_MINIMOS_FECHA_COMPRA+CONSTANTE_NUMERICA)+DIAS_MINIMOS_FECHA_COMPRA);
	}

}
