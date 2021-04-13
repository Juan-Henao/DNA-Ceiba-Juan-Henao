update cliente
set
	nombres = :nombres,
		apellidos = :apellidos,
		identificacion = :identificacion,
		email = :email,
		fechaCreacion = :fechaCreacion
where id = :id	