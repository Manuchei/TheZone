package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import TheZone.modelo.entity.Carrito;
import TheZone.modelo.entity.Usuario;
import TheZone.modelo.repository.CarritoRepository;
import TheZone.modelo.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;


@Service
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	private CarritoRepository cr;
	
	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public Carrito buscarPorIdCarrito(int idCarrito) {
		return cr.findById(idCarrito).orElse(null);
	}
	
	@Override
	public Carrito buscarPorUsuario(int idUsuario) {
		//Usuario usuario = ur.findById(idUsuario).orElse(null);
		return cr.findByUsuario_IdUsuario(idUsuario);
	}

	@Override
	public Carrito alta(Carrito carrito) {
		try {
			if (cr.findByUsuario_IdUsuario(carrito.getUsuario().getIdUsuario()) != null) {
				return null;
			}
			else {
				return cr.save(carrito);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String eliminar(int idUsuario) {

		try { 
			if (cr.findByUsuario_IdUsuario(idUsuario) != null) {
				Carrito carrito = cr.findByUsuario_IdUsuario(idUsuario);
				cr.deleteById(carrito.getIdCarrito());
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
