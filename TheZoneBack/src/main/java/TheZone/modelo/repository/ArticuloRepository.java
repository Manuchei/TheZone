package TheZone.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import TheZone.modelo.entity.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
	
	public List<Articulo> findByActivo(Boolean activo);
}
