package TheZone.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/articulos/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService us;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> todos() {
        return new ResponseEntity<List<Usuario>>(us.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> alta(@RequestBody Usuario usuario) {
        return new ResponseEntity<Usuario>(us.alta(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> eliminar(@PathVariable int idUsuario) {
        switch (us.eliminar(idUsuario)) {
        case "1":
            return new ResponseEntity<String>("Usuario borrado correctamente", HttpStatus.OK);
        case "0":
            return new ResponseEntity<String>("Este usuario no existe", HttpStatus.NOT_FOUND);
        default:
            return null;
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> modificar(@RequestBody Usuario articulo) {
        return new ResponseEntity<Usuario>(us.modificar(articulo), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = us.alta(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "No se pudo registrar el usuario");
            error.put("details", e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario credenciales) {
        try {
            Usuario usuario = us.loginUsuario(credenciales.getEmail(), credenciales.getPassword());
            if (usuario != null) {
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
