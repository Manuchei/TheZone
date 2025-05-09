package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.Articulo;
import TheZone.modelo.entity.Usuario;

public interface ArticuloService {

	Articulo buscarUno(int idArticulo);
	
	List<Articulo> buscarTodos();
	
	List<Articulo> buscarActivos();
	
	List<Articulo> buscarSeccion(int idSeccion);

	Articulo alta(Articulo articulo);

	String eliminar(int idArticulo);

	Articulo modificar(Articulo articulo);

}
