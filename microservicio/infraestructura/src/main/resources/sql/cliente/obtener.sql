select 
c.id as id_cliente,
c.nombres as nombres_cliente,
c.apellidos as apellidos_cliente,
c.identificacion as identificacion_paciente,
c.email as email_paciente,
c.fechaCreacion as fecha_creacion_cliente
from cliente c
where id = :id