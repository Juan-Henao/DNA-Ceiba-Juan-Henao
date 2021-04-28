package com.ceiba.adaptador.maps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoUsuario;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idRol = resultSet.getLong("idRol");
        String password = resultSet.getString("password");
        String username = resultSet.getString("username");
        
        return new DtoUsuario(id, idRol, password, username);
    }

}
 