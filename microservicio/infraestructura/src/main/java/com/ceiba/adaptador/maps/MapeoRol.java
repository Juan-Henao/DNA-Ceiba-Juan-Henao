package com.ceiba.adaptador.maps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoRol;

public class MapeoRol implements RowMapper<DtoRol>, MapperResult {

    @Override
    public DtoRol mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre_rol = resultSet.getString("nombre_rol");

        
        return new DtoRol(id, nombre_rol);
    }

}
 