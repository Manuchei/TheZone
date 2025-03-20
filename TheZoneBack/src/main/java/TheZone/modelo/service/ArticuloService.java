package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.Articulo;
import TheZone.modelo.entity.Usuario;

public interface ArticuloService {

	List<Articulo> buscarTodos();

	Articulo alta(Articulo articulo);

	String eliminar(int idArticulo);

	Articulo modificar(Articulo articulo);

}
