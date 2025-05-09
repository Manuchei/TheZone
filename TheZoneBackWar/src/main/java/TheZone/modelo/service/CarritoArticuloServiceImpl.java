package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.Carrito;
import TheZone.modelo.entity.CarritoArticulo;
import TheZone.modelo.repository.CarritoArticulosRepository;

@Service
public class CarritoArticuloServiceImpl implements CarritoArticuloService{

	@Autowired
	private CarritoArticulosRepository carepository;
	
	@Override
	public List<CarritoArticulo> buscarPorCarrito(int idCarrito) {
		return carepository.findByCarrito_IdCarrito(idCarrito);
	}

	@Override
	public CarritoArticulo alta(CarritoArticulo carritoArticulo) {
		try {
			if (carepository.existsById(carritoArticulo.getIdCarritoArticulo())) {
				return null;
			}
			else {
				return carepository.save(carritoArticulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String eliminar(int idCarritoArticulo) {
		try { 
			if (carepository.existsById(idCarritoArticulo)) {
				carepository.deleteById(idCarritoArticulo);
				return "1";
			} else
				return "0";
		}
			catch(Exception e) {
				e.printStackTrace();
				return "-1";
			}
	}

	@Override
	public CarritoArticulo modificar(CarritoArticulo carritoArticulo) {
		try {
			if (carepository.existsById(carritoArticulo.getIdCarritoArticulo()))
				return carepository.save(carritoArticulo);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
