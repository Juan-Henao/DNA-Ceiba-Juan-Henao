package com.ceiba.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

	private Long id;
	private Long idRol;
	private String password;
	private String username;

	public ComandoUsuarioTestDataBuilder() {

		idRol = Long.parseLong(UUID.randomUUID().toString());
		password = "12345";
		username = "juanHenao";

	}

	public ComandoUsuarioTestDataBuilder conNombre(String username) {
		this.username = username;
		return this;
	}

	public ComandoUsuario build() {
		return new ComandoUsuario(id, idRol, password, username);
	}
}
