package com.ceiba.adaptador.dao;

import java.util.List;

import com.ceiba.adaptador.maps.MapeoParametro;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.DtoParametro;
import com.ceiba.modelo.util.EnumParametro;
import com.ceiba.puerto.dao.DaoParametro;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoParametroMysql implements DaoParametro {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="parametro", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="parametro", value="obtener")
    private static String sqlObtener;
    
    @SqlStatement(namespace="parametro", value="obtenerPorEnum")
    private static String sqlObtenerPorEnum;
    
    
    public DaoParametroMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


	@Override
	public List<DtoParametro> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoParametro());
	}

	@Override
	public DtoParametro obtener(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoParametro()).iterator().next();
	}


	@Override
	public DtoParametro obtenerPorEnum(EnumParametro enumParametro) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("enumParametro", enumParametro);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPorEnum, paramSource, new MapeoParametro()).iterator().next();
	}



}
