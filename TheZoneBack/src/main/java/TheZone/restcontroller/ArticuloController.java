package TheZone.restcontroller;

import java.util.List;

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

import TheZone.modelo.entity.Articulo;
import TheZone.modelo.service.ArticuloService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/articulos")
public class ArticuloController {
	@Autowired
	private ArticuloService as;

	/*@GetMapping("/")
	public List<Articulo> todos() {
		return as.buscarTodos();
	}*/
	
	@GetMapping("/")
	public ResponseEntity<List<Articulo>> todos() {
		return new ResponseEntity<List<Articulo>>(as.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/activos")
	public ResponseEntity<List<Articulo>> todosActivos() {
		return new ResponseEntity<List<Articulo>>(as.buscarActivos(), HttpStatus.OK);
	}

	/*@PostMapping("/")
	public Articulo alta(@RequestBody Articulo articulo) {
		return as.alta(articulo);
	}*/
	
	@PostMapping("/")
	public ResponseEntity<?> alta(@RequestBody Articulo articulo) {
		return new ResponseEntity<Articulo>(as.alta(articulo), HttpStatus.CREATED);
	}

	/*@DeleteMapping("/{idArticulo}")
	public String eliminar(@PathVariable int idArticulo) {
		switch (as.eliminar(idArticulo)) {
		case "1":
			return "Cliente borrado correctamente";
		case "0":
			return "Este cliente no existe";
		default:
			return null;
		}
	}*/
	
	@DeleteMapping("/{idArticulo}")
	public ResponseEntity<String> eliminar(@PathVariable int idArticulo) {
		switch (as.eliminar(idArticulo)) {
		case "1":
			return new ResponseEntity<String>("Artículo borrado correctamente", HttpStatus.OK);
		case "0":
			return new ResponseEntity<String>("Este artículo no existe", HttpStatus.NOT_FOUND);
		default:
			return null;		
		}
	}

	/*@PutMapping("/")
	public Articulo modificar(@RequestBody Articulo articulo) {
		return as.modificar(articulo);
	}*/
	
	@PutMapping("/")
	public ResponseEntity<?> modificar(@RequestBody Articulo articulo) {
		return new ResponseEntity<Articulo>(as.modificar(articulo), HttpStatus.OK);
	}

}
