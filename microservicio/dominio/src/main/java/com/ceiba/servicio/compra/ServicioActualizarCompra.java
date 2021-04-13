package com.ceiba.servicio.compra;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.dto.DtoItemsCompra;
import com.ceiba.modelo.entidad.Compra;
import com.ceiba.puerto.repositorio.RepositorioCompra;

public class ServicioActualizarCompra {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La Compra ya existe en el sistema";
	private static final Double MULTA_CANCELACION_COMPRA = 50000.00;


	private final RepositorioCompra repositorioCompra;

	public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}

	public void ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);
		if (validarCancelacionCompra(compra)) {
			cancelarCompra(compra);
		}
		this.repositorioCompra.actualizar(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existeExcluyendoId(compra.getId(),compra.getFechaCompra(),compra.getIdCliente());
		if(existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}


	private boolean validarCancelacionCompra(Compra compra) {

		return true;
	}

	private void cancelarCompra(Compra compra) {
		compra.setTotal(MULTA_CANCELACION_COMPRA);
	}
}
