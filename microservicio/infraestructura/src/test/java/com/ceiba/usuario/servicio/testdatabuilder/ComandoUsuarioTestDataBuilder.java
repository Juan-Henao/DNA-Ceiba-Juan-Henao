package com.ceiba.usuario.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

    /*private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fecha;*/

	private Long id;
	private Long idRol;
	private String password;
	private String username;
	
    public ComandoUsuarioTestDataBuilder() {
        /*nombre = UUID.randomUUID().toString();
        clave = "1234";
        fecha = LocalDateTime.now();*/
    	
    	idRol = Long.parseLong( UUID.randomUUID().toString());
    	password = "1234";
    	username = "testName";
    	
    }

    /*public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }*/

    public ComandoUsuarioTestDataBuilder conNombre(String username) {
        this.username = username;
        return this;
    }
    
    public ComandoUsuario build() {
        //return new ComandoUsuario(id,nombre, clave,fecha);
    	return new ComandoUsuario(id,idRol,password,username);
    }
}
