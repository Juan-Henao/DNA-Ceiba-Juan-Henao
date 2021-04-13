select 
c.id as id_cliente,
c.nombres as nombres_cliente,
c.apellidos as apellidos_cliente,
c.identificacion as identificacion_paciente,
c.email as email_paciente,
c.fechaCreacion as fecha_creacion_cliente,
co.id as id_compra,
co.total as total_compra,
co.fechaCompra as fecha_compra,
co.fechaEntrega as fecha_entrega

from cliente c
	inner join compra co on c.id = co.idCliente;

	
