package TheZone.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TheZone.modelo.entity.CarritoArticulo;

public interface CarritoArticulosRepository extends JpaRepository<CarritoArticulo, Integer>{

	public List<CarritoArticulo> findByCarrito_IdCarrito(int idCarrito);
}
