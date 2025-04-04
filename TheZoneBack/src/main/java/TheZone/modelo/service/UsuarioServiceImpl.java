package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.Usuario;
import TheZone.modelo.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario alta(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public String eliminar(int idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            usuarioRepository.deleteById(idUsuario);
            return "1";
        }
        return "0";
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        validarUsuario(usuario);

        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario loginUsuario(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getUsername() == null || usuario.getEmail() == null || usuario.getPassword() == null) {
            throw new IllegalArgumentException("Los campos requeridos están incompletos.");
        }
    }
}