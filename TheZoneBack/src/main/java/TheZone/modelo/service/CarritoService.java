package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.Carrito;


public interface CarritoService {

	Carrito buscarUno(int idCarrito);

	Carrito alta(Carrito carrito);

	String eliminar(int idCarrito);

	Carrito modificar(Carrito carrito);
	
}
