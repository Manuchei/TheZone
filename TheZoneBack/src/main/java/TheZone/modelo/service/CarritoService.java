package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.Carrito;
import TheZone.modelo.entity.Usuario;


public interface CarritoService {

	Carrito buscarPorIdCarrito(int idCarrito);
	
	Carrito buscarPorUsuario(int idUsuario);

	Carrito alta(Carrito carrito);

	String eliminar(int idUsuario);

	Carrito modificar(Carrito carrito);
	
}
