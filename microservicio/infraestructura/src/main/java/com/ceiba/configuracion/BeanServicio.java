package com.ceiba.configuracion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.puerto.repositorio.RepositorioCliente;
import com.ceiba.puerto.repositorio.RepositorioCompra;
import com.ceiba.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.puerto.repositorio.RepositorioRol;
import com.ceiba.puerto.repositorio.RepositorioUsuario;
import com.ceiba.servicio.cliente.ServicioActualizarCliente;
import com.ceiba.servicio.cliente.ServicioCrearCliente;
import com.ceiba.servicio.cliente.ServicioEliminarCliente;
import com.ceiba.servicio.compra.ServicioActualizarCompra;
import com.ceiba.servicio.compra.ServicioCrearCompra;
import com.ceiba.servicio.compra.ServicioEliminarCompra;
import com.ceiba.servicio.itemsCompra.ServicioActualizarItemsCompra;
import com.ceiba.servicio.itemsCompra.ServicioCrearItemsCompra;
import com.ceiba.servicio.itemsCompra.ServicioEliminarItemsCompra;
import com.ceiba.servicio.rol.ServicioActualizarRol;
import com.ceiba.servicio.rol.ServicioCrearRol;
import com.ceiba.servicio.rol.ServicioEliminarRol;
import com.ceiba.servicio.usuario.ServicioActualizarUsuario;
import com.ceiba.servicio.usuario.ServicioCrearUsuario;
import com.ceiba.servicio.usuario.ServicioEliminarUsuario;


@Configuration
public class BeanServicio {

	/*
	 * 
	 * SERVICIOS DEL CLIENTE
	 * 
	 */
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }
    
	/*
	 * 
	 * SERVICIOS DEL COMPRA
	 * 
	 */
    @Bean
    public ServicioCrearCompra servicioCrearCompra(RepositorioCompra repositorioCompra) {
        return new ServicioCrearCompra(repositorioCompra);
    }

    @Bean
    public ServicioEliminarCompra servicioEliminarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioEliminarCompra(repositorioCompra);
    }

    @Bean
    public ServicioActualizarCompra servicioActualizarCompra(RepositorioCompra repositorioCompra) {
        return new ServicioActualizarCompra(repositorioCompra);
    }
    
    /*
	 * 
	 * SERVICIOS DE ITEMSCOMPRA
	 * 
	 */
    @Bean
    public ServicioCrearItemsCompra servicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        return new ServicioCrearItemsCompra(repositorioItemsCompra);
    }

    @Bean
    public ServicioEliminarItemsCompra servicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        return new ServicioEliminarItemsCompra(repositorioItemsCompra);
    }

    @Bean
    public ServicioActualizarItemsCompra servicioActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        return new ServicioActualizarItemsCompra(repositorioItemsCompra);
    }
    
    /*
	 * 
	 * SERVICIOS DE ROL
	 * 
	 */
    @Bean
    public ServicioCrearRol servicioCrearRol(RepositorioRol repositorioRol) {
        return new ServicioCrearRol(repositorioRol);
    }

    @Bean
    public ServicioEliminarRol servicioEliminarRol(RepositorioRol repositorioRol) {
        return new ServicioEliminarRol(repositorioRol);
    }

    @Bean
    public ServicioActualizarRol servicioActualizarRol(RepositorioRol repositorioRol) {
        return new ServicioActualizarRol(repositorioRol);
    }
    
	/*
	 * 
	 * SERVICIOS DEL USUARIO
	 * 
	 */
    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	

}
