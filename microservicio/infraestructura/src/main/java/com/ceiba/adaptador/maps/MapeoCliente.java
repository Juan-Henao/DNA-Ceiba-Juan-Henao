package com.ceiba.adaptador.maps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.DtoCliente;

import org.springframework.jdbc.core.RowMapper;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
    	 String nombres = resultSet.getString("nombres");
    	 String apellidos = resultSet.getString("apellidos");
    	 String identificacion = resultSet.getString("identificacion");
    	 String email = resultSet.getString("email");
    	 LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fechaCreacion");
        
        return new DtoCliente(id, nombres, apellidos, identificacion, email, fechaCreacion);
    }

}
 