package TheZone.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TheZone.modelo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
