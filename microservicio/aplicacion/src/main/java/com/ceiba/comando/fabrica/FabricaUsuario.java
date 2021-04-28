package com.ceiba.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.comando.ComandoUsuario;
import com.ceiba.modelo.entidad.Usuario;

@Component
public class FabricaUsuario {

	public Usuario crear(ComandoUsuario comandoUsuario) {
		return new Usuario(comandoUsuario.getId(),
				comandoUsuario.getIdRol(),
				comandoUsuario.getPassword(),
				comandoUsuario.getUsername());
		
	}

}
