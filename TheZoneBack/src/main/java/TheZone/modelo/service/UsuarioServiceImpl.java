package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.Usuario;
import TheZone.modelo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository ur;

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	@Override
	public Usuario alta(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			if (ur.existsById(usuario.getIdUsuario()))
				return null;
			else
				return ur.save(usuario);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public String eliminar(int idUsuario) {
		// TODO Auto-generated method stub
		try {
			if (ur.existsById(idUsuario)) {
				ur.deleteById(idUsuario);
				return "1";
			} else
				return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public Usuario modificar(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			if (ur.existsById(usuario.getIdUsuario()))
				return ur.save(usuario);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}