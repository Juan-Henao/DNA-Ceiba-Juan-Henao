package com.ceiba.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import lombok.Getter;

@Getter
public class Usuario {
	
	private static final String SE_DEBE_INGRESAR_USERNAME = "Se debe ingresar el username";
	private static final String SE_DEBE_INGRESAR_PASSWORD = "Se debe ingresar la contrase\u00f1a";
	private static final String SE_DEBE_SELECCIONAR_ROL = "Se debe seleccionar un rol";

	private Long id;
	private Long idRol;
	private String password;
	private String username;
	
	public Usuario(Long id,Long idRol, String password, String username) {
		validarObligatorio(password, SE_DEBE_INGRESAR_PASSWORD);
		validarObligatorio(username, SE_DEBE_INGRESAR_USERNAME);
		validarObligatorio(idRol, SE_DEBE_SELECCIONAR_ROL);

		this.id = id;
		this.password = password;
		this.username = username;
		this.idRol = idRol;
	}

}
