package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.CarritoArticulo;

public interface CarritoArticuloService {

	List<CarritoArticulo> buscarPorCarrito(int idCarrito);
	CarritoArticulo alta(CarritoArticulo carritoArticulo);
	String eliminar(int idCarritoArticulo);
	CarritoArticulo modificar(CarritoArticulo carritoArticulo);
}
