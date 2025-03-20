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

import TheZone.modelo.entity.Articulo;
import TheZone.modelo.service.ArticuloService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/articulos")
public class ArticuloController {
	@Autowired
	private ArticuloService as;

	@GetMapping("/")
	public List<Articulo> todos() {
		return as.buscarTodos();
	}

	@PostMapping("/")
	public Articulo alta(@RequestBody Articulo articulo) {
		return as.alta(articulo);
	}

	@DeleteMapping("/{idArticulo}")
	public String eliminar(@PathVariable int idArticulo) {
		switch (as.eliminar(idArticulo)) {
		case "1":
			return "Cliente borrado correctamente";
		case "0":
			return "Este cliente no existe";
		default:
			return null;
		}
	}

	@PutMapping("/")
	public Articulo modificar(@RequestBody Articulo articulo) {
		return as.modificar(articulo);
	}

}
