package TheZone.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TheZone.modelo.entity.OpinionArticulo;

public interface OpinionArticuloRepository extends JpaRepository<OpinionArticulo, Integer>{

	public List<OpinionArticulo> findByUsuario_IdUsuario(int idUsuario);
	public List<OpinionArticulo> findByArticulo_IdArticulo(int idArticulo);
}
