package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.Seccion;
import TheZone.modelo.repository.SeccionRepository;

@Service
public class SeccionServiceImpl implements SeccionService{

	@Autowired
	SeccionRepository srepository;
	
	@Override
	public Seccion buscarUno(int idSeccion) {
		return srepository.findById(idSeccion).orElse(null);
	}

	@Override
	public List<Seccion> buscarTodos() {
		// TODO Auto-generated method stub
		return srepository.findAll();
	}

	@Override
	public Seccion alta(Seccion seccion) {
		try {
			if(srepository.existsById(seccion.getIdSeccion())) {
				return null;
			}else {
				return srepository.save(seccion);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String eliminar(int idSeccion) {
		try {
			if(srepository.existsById(idSeccion)) {
				srepository.deleteById(idSeccion);
				return "1";
			}else {
				return "0";
			}
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Seccion modificar(Seccion seccion) {
		try {
			if(srepository.existsById(seccion.getIdSeccion())) {
				return srepository.save(seccion);
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
