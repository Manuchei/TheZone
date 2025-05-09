package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.OpinionArticulo;

public interface OpinionArticuloService {

	List<OpinionArticulo> buscarPorUsuario(int idUsuario);
	List<OpinionArticulo> buscarPorArticulo(int idArticulo);
	OpinionArticulo alta(OpinionArticulo opinionArticulo);
	String eliminar(int idOpinion);
	OpinionArticulo modificar(OpinionArticulo opinionArticulo);
}
