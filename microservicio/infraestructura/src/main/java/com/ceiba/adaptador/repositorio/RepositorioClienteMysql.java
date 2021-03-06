package com.ceiba.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.Cliente;
import com.ceiba.puerto.repositorio.RepositorioCliente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteMysql implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cliente", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="cliente", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="cliente", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="cliente", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioClienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

	@Override
	public Long crear(Cliente Cliente) {
        return this.customNamedParameterJdbcTemplate.crear(Cliente, sqlCrear);

	}

	@Override
	public void actualizar(Cliente Cliente) {
        this.customNamedParameterJdbcTemplate.actualizar(Cliente, sqlActualizar);
		
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);		
	}

	@Override
	public boolean existe(String identificacion) {
		 MapSqlParameterSource paramSource = new MapSqlParameterSource();
	        paramSource.addValue("identificacion", identificacion);

	        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public boolean existeExcluyendoId(Long id, String identificacion) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("identificacion", identificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
	}

	

    
}
