package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.Carrito;
import TheZone.modelo.repository.CarritoRepository;

@Service
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	private CarritoRepository cr;
	
	@Override
	public Carrito buscarUno(int idCarrito) {
		return cr.findById(idCarrito).orElse(null);
	}

	@Override
	public Carrito alta(Carrito carrito) {
		try {
			if (cr.existsById(carrito.getIdCarrito()))
				return null;
			else {
				carrito.setIdCarrito(1);;
				return cr.save(carrito);
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String eliminar(int idCarrito) {

		try { 
			if (cr.existsById(idCarrito)) {
				cr.deleteById(idCarrito);
				return "1";
			} else
				return "0";
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return "0";
	}

	@Override
	public Carrito modificar(Carrito carrito) {
		// TODO Auto-generated method stub
		try {
			if (cr.existsById(carrito.getIdCarrito()))
				return cr.save(carrito);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
