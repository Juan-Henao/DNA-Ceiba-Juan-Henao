package com.ceiba.controlador.rol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoRol;
import com.ceiba.comando.manejador.rol.ManejadorActualizarRol;
import com.ceiba.comando.manejador.rol.ManejadorCrearRol;
import com.ceiba.comando.manejador.rol.ManejadorEliminarRol;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rol")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorRol {

    private final ManejadorCrearRol ManejadorCrearRol;
	private final ManejadorEliminarRol manejadorEliminarRol;
	private final ManejadorActualizarRol manejadorActualizarRol;

    @Autowired
    public ComandoControladorRol(ManejadorCrearRol ManejadorCrearRol,
									 ManejadorEliminarRol manejadorEliminarRol,
									 ManejadorActualizarRol manejadorActualizarRol) {
        this.ManejadorCrearRol = ManejadorCrearRol;
		this.manejadorEliminarRol = manejadorEliminarRol;
		this.manejadorActualizarRol = manejadorActualizarRol;
    }

    @PostMapping
    @ApiOperation("Crear rol")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRol comandoRol) {
        return ManejadorCrearRol.ejecutar(comandoRol);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarRol.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar rol")
	public void actualizar(@RequestBody ComandoRol comandoRol,@PathVariable Long id) {
		comandoRol.setId(id);
		manejadorActualizarRol.ejecutar(comandoRol);
	}
}
