package com.ceiba.controlador.rol;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.usuario.ManejadorListarUsuarios;
import com.ceiba.consulta.usuario.ManejadorObtenerUsuario;
import com.ceiba.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rol")
@Api(tags={"Controlador consulta rol"})
public class ConsultaControladorRol {

    private final ManejadorListarUsuarios manejadorListarUsuarios;
    private final ManejadorObtenerUsuario manejadorObtenerUsuario;

    public ConsultaControladorRol(ManejadorListarUsuarios manejadorListarUsuarios, ManejadorObtenerUsuario manejadorObtenerUsuario) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
        this.manejadorObtenerUsuario = manejadorObtenerUsuario;

    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener rol")
    public DtoUsuario obtener(@PathVariable Long id) {
    	return this.manejadorObtenerUsuario.ejecutar(id);
    }
    
    @GetMapping(value = "/only/{username}")
    @ApiOperation("Obtener rol")
    public DtoUsuario obtenerPorUsuario(@PathVariable String username) {
    	return this.manejadorObtenerUsuario.ejecutar(username);
    }

    @GetMapping
    @ApiOperation("Listar rol")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

}
