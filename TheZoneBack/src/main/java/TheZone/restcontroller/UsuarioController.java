package TheZone.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TheZone.modelo.entity.Usuario;
import TheZone.modelo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService us;

	@GetMapping("/")
	public List<Usuario> todos() {
		return us.buscarTodos();
	}

	@PostMapping("/")
	public Usuario alta(@RequestBody Usuario usuario) {
		return us.alta(usuario);
	}

	@DeleteMapping("/{idUsuario}")
	public String eliminar(@PathVariable int idUsuario) {
		switch (us.eliminar(idUsuario)) {
		case "1":
			return "Usuario borrado correctamente";
		case "0":
			return "Este usuario no existe";
		default:
			return null;
		}
	}

	@PutMapping("/")
	public Usuario modificar(@RequestBody Usuario usuario) {
		return us.modificar(usuario);
	}

}