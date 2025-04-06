package TheZone.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TheZone.modelo.entity.Carrito;


public interface CarritoRepository extends JpaRepository<Carrito, Integer>{

	public Carrito findByUsuario_IdUsuario(int idUsuario);
}
