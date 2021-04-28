package com.ceiba.controlador.parametro;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.consulta.parametro.ManejadorListarParametros;
import com.ceiba.modelo.dto.DtoParametro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/parametro")
@Api(tags={"Controlador consulta parametro"})
public class ConsultaControladorParametro {

    private final ManejadorListarParametros manejadorListarParametro;

    public ConsultaControladorParametro(ManejadorListarParametros manejadorListarParametro) {
        this.manejadorListarParametro = manejadorListarParametro;
    }

    @GetMapping
    @ApiOperation("Listar parametro")
    public List<DtoParametro> listar() {
        return this.manejadorListarParametro.ejecutar();
    }

}
