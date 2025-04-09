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
import TheZone.modelo.entity.Seccion;
import TheZone.modelo.service.ArticuloService;
import TheZone.modelo.service.SeccionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/secciones")
public class SeccionController {
	
	@Autowired
	private SeccionService sservice;
	
	@Autowired
	private ArticuloService aservice;
	
	@GetMapping("/{idSeccion}")
	public ResponseEntity<Seccion> uno(@PathVariable int idSeccion) {
		return new ResponseEntity<Seccion>(sservice.buscarUno(idSeccion), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Seccion>> todos() {
		return new ResponseEntity<List<Seccion>>(sservice.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/todoArticulos/{idSeccion}")
	public ResponseEntity<List<Articulo>> listadoArticulos(@PathVariable int idSeccion) {
		return new ResponseEntity<List<Articulo>>(aservice.buscarSeccion(idSeccion), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Seccion> alta(@RequestBody Seccion seccion) {
		return new ResponseEntity<Seccion>(sservice.alta(seccion), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idSeccion}")
	public ResponseEntity<String> eliminar(@PathVariable int idSeccion) {
		switch (sservice.eliminar(idSeccion)) {
		case "1":
			return new ResponseEntity<String>("seccion eliminada correctamente", HttpStatus.OK);
		case "0":
			return new ResponseEntity<String>("Esta seccion no existe", HttpStatus.NOT_FOUND);
		default:
			return null;		
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> modificar(@RequestBody Seccion seccion) {
		return new ResponseEntity<Seccion>(sservice.modificar(seccion), HttpStatus.OK);
	}

}
