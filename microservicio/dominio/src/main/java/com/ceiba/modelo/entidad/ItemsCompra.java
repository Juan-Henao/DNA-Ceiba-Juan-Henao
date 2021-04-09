package com.ceiba.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarMayorDouble;

@Getter
public class ItemsCompra {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creaci\u00f3n";
    private static final String SE_DEBE_INGRESAR_EL_ANCHO_DEL_CRISTAL = "Se debe ingresar el ancho del cristal";
    private static final String SE_DEBE_INGRESAR_EL_LARGO_DEL_CRISTAL = "Se debe ingresar el largo del cristal";
	private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DEL_CRISTAL = "Se debe ingresar la cantidad del cristal";
	private static final String SE_DEBE_ASIGNAR_COMPRA = "Se debe asignar la compra";
	private static final String SE_DEBE_INGRESAR_VALOR_VALIDO_ANCHO = "Se debe ingresar el un valor valido en el ancho";
	private static final String SE_DEBE_INGRESAR_VALOR_VALIDO_LARGO = "Se debe ingresar el un valor valido en el largo";

	private static final Double LONGITUD_MAXIMA_ANCHO = 4.0;
    private static final Double LONGITUD_MAXIMA_LARGO = 4.0;

    private Long id;
    private Long cantidad;
	private Long idCompra;
	private Double valor;
    private Double ancho;
    private Double largo;
	private LocalDateTime fechaCreacion;

	public ItemsCompra(Long id, Double ancho, Double largo, Double valor, Long cantidad, LocalDateTime fechaCreacion,
			Long idCompra) {
		
        validarObligatorio(ancho, SE_DEBE_INGRESAR_EL_ANCHO_DEL_CRISTAL);
        validarObligatorio(largo, SE_DEBE_INGRESAR_EL_LARGO_DEL_CRISTAL);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD_DEL_CRISTAL);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(idCompra, SE_DEBE_ASIGNAR_COMPRA);
        validarObligatorio(valor, SE_DEBE_ASIGNAR_COMPRA);
        validarMayorDouble(ancho,LONGITUD_MAXIMA_ANCHO ,SE_DEBE_INGRESAR_VALOR_VALIDO_ANCHO);
        validarMayorDouble(largo,LONGITUD_MAXIMA_LARGO ,SE_DEBE_INGRESAR_VALOR_VALIDO_LARGO);

		this.id = id;
		this.ancho = ancho;
		this.largo = largo;
		this.cantidad = cantidad;
		this.fechaCreacion = fechaCreacion;
		this.idCompra = idCompra;
		this.valor = valor;
	}

}
