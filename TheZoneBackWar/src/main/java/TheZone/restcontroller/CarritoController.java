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

import TheZone.dto.CarritoArticuloDto;
import TheZone.dto.CarritoDto;
import TheZone.modelo.entity.Carrito;
import TheZone.modelo.entity.CarritoArticulo;
import TheZone.modelo.entity.Usuario;
import TheZone.modelo.service.ArticuloService;
import TheZone.modelo.service.CarritoArticuloService;
import TheZone.modelo.service.CarritoService;
import TheZone.modelo.service.UsuarioService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	private CarritoArticuloService cas;
	
	@Autowired
	private CarritoService cs;
	
	@Autowired
	private UsuarioService us;
	
	@Autowired
	private ArticuloService as;
	
	//Carrito
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Carrito> buscarUno(@PathVariable int idUsuario) {
		//Usuario usuario = us.buscarUno(idUsuario);
		return new ResponseEntity<Carrito>(cs.buscarPorUsuario(idUsuario), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Carrito> alta(@RequestBody CarritoDto carritoDto) {
		Carrito carrito = new Carrito();
		carrito.setUsuario(us.buscarUno(carritoDto.getIdUsuario()));
		carrito.setTotalPago(carritoDto.getTotalPago());
		
		return new ResponseEntity<Carrito>(cs.alta(carrito), HttpStatus.CREATED);
		//return new ResponseEntity<Carrito>(carrito, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<String> eliminar(@PathVariable int idUsuario) {
		switch (cs.eliminar(idUsuario)) {
		case "1":
			return new ResponseEntity<String>("Carrito borrado correctamente", HttpStatus.OK);
		case "0":
			return new ResponseEntity<String>("Este carrito no existe", HttpStatus.NOT_FOUND);
		case "-1":
			return new ResponseEntity<String>("Esto es un problema de la base de datos", HttpStatus.CONFLICT);
		default:
			return null;
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Carrito> modificar(@RequestBody CarritoDto carritoDto){
		Carrito carrito = new Carrito();
		carrito.setIdCarrito(cs.buscarPorUsuario(carritoDto.getIdUsuario()).getIdCarrito());
		carrito.setUsuario(us.buscarUno(carritoDto.getIdUsuario()));
		carrito.setTotalPago(carritoDto.getTotalPago());
		
		return new ResponseEntity<Carrito>(cs.modificar(carrito), HttpStatus.OK);
	}
	
	//Lineas Carrito
	@GetMapping("/lineas/{idCarrito}")
	public ResponseEntity<List<CarritoArticulo>> buscarPorCarrito(@PathVariable int idCarrito){
		return new ResponseEntity<List<CarritoArticulo>>(cas.buscarPorCarrito(idCarrito), HttpStatus.OK);
	}
	
	@GetMapping("/lineasTotal/{idCarrito}")
	public ResponseEntity<Double> totalCarrito(@PathVariable int idCarrito){
		List<CarritoArticulo> lineasCarrito = cas.buscarPorCarrito(idCarrito);
		double total = 0;
		
		for (CarritoArticulo linea : lineasCarrito) {
			total += linea.getTotalImporte();
		}
		
		return new ResponseEntity<Double>(total, HttpStatus.OK);
	}
	
	@PostMapping("/lineas")
	public ResponseEntity<CarritoArticulo> altaLinea(@RequestBody CarritoArticuloDto caDto){
		CarritoArticulo ca = new CarritoArticulo();
		ca.setCarrito(cs.buscarPorIdCarrito(caDto.getIdCarrito()));
		ca.setArticulo(as.buscarUno(caDto.getIdArticulo()));
		ca.setCantidad(caDto.getCantidad());
		ca.setPrecio(caDto.getPrecio());
		ca.setTotalImporte(caDto.getTotalImporte());
		
		return new ResponseEntity<CarritoArticulo>(cas.alta(ca), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/lineas/{idCarritoArticulo}")
	public ResponseEntity<String> eliminarLinea(@PathVariable int idCarritoArticulo) {
		switch (cas.eliminar(idCarritoArticulo)) {
		case "1":
			return new ResponseEntity<String>("Linea del carrito borrado correctamente", HttpStatus.OK);
		case "0":
			return new ResponseEntity<String>("Esta linea del carrito no existe", HttpStatus.NOT_FOUND);
		case "-1":
			return new ResponseEntity<String>("Esto es un problema de la base de datos", HttpStatus.CONFLICT);
		default:
			return null;
		}
	}
	
	@PutMapping("/lineas")
	public ResponseEntity<CarritoArticulo> modificarLinea(@RequestBody CarritoArticuloDto caDto){
		CarritoArticulo ca = new CarritoArticulo();
		ca.setIdCarritoArticulo(caDto.getIdCarritoArticulo());
		ca.setCarrito(cs.buscarPorIdCarrito(caDto.getIdCarrito()));
		ca.setArticulo(as.buscarUno(caDto.getIdArticulo()));
		ca.setCantidad(caDto.getCantidad());
		ca.setPrecio(caDto.getPrecio());
		ca.setTotalImporte(caDto.getTotalImporte());
		
		return new ResponseEntity<CarritoArticulo>(cas.modificar(ca), HttpStatus.OK);
	}
}
