package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.Articulo;
import TheZone.modelo.repository.ArticuloRepository;

@Service
public class ArticuloServiceImpl implements ArticuloService {

	@Autowired
	private ArticuloRepository ar;

	@Override
	public Articulo buscarUno(int idArticulo) {
		return ar.findById(idArticulo).orElse(null);
	}
	
	@Override
	public List<Articulo> buscarTodos() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}
	
	@Override
	public List<Articulo> buscarActivos() {
		// TODO Auto-generated method stub
		return ar.findByActivo(true);
	}

	@Override
	public Articulo alta(Articulo articulo) {
		// TODO Auto-generated method stub
		try {
			if (ar.existsById(articulo.getIdArticulo()))
				return null;
			else {
				articulo.setActivo(true);
				return ar.save(articulo);
			}
		} catch (Exception e) {
			return null;
		}

	}

	/*@Override
	public String eliminar(int idArticulo) {
		// TODO Auto-generated method stub
		try {
			if (ar.existsById(idArticulo)) {
				ar.deleteById(idArticulo);
				return "1";
			} else
				return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}*/
	
	@Override
	public String eliminar(int idArticulo) {
		// TODO Auto-generated method stub
		Articulo articulo = ar.findById(idArticulo).orElse(null);
		
		try {
			if (ar.existsById(idArticulo)) {
				articulo.setActivo(false);
				ar.save(articulo);
				return "1";
			} else
				return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public Articulo modificar(Articulo articulo) {
		// TODO Auto-generated method stub
		try {
			if (ar.existsById(articulo.getIdArticulo()))
				return ar.save(articulo);
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}