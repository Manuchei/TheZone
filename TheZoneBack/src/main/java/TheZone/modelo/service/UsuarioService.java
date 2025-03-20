package TheZone.modelo.service;

import java.util.List;

import TheZone.modelo.entity.Usuario;

public interface UsuarioService {

	List<Usuario> buscarTodos();

	Usuario alta(Usuario usuario);

	String eliminar(int idUsuario);

	Usuario modificar(Usuario usuario);

}
