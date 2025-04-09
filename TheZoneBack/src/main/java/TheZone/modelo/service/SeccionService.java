package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.Seccion;


public interface SeccionService {
	
	Seccion buscarUno(int idSeccion);
	List<Seccion> buscarTodos();
	Seccion alta(Seccion seccion);
	String eliminar(int idSeccion);
	Seccion modificar(Seccion seccion);

}
