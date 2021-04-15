update compra
set idCliente = :idCliente,
	total = :total,
		fechaCompra = :fechaCompra,	
	fechaEntrega = :fechaEntrega,
	enumParametro = :enumParametro
where id = :id
