package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoRol;
import com.ceiba.modelo.entidad.Rol;

@Component
public class FabricaRol {

	public Rol crear(ComandoRol comandoRol) {
		return new Rol(comandoRol.getId(),
				comandoRol.getNombre_rol());
	}

}
