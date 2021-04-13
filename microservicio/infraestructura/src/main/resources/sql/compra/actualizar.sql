update compra
set idCliente = :idCliente,
	total = :total,
		fechaCompra = :fechaCompra,	
	fechaEntrega = :fechaEntrega
where id = :id
