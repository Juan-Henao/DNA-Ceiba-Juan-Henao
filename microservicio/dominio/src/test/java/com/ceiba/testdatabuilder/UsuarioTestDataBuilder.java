package com.ceiba.testdatabuilder;

import com.ceiba.modelo.entidad.Usuario;


public class UsuarioTestDataBuilder {


	private Long id;
	private Long idRol;
	private String password;
	private String username;
	
    public UsuarioTestDataBuilder() {
    	username = "1234";
    	password = "1234";
    	idRol = 1l;
        
    }

    public UsuarioTestDataBuilder conPassword(String password) {
        this.password = password;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, idRol, password, username);
    }
}
