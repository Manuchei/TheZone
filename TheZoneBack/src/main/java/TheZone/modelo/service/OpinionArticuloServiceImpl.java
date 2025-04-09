package TheZone.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TheZone.modelo.entity.OpinionArticulo;
import TheZone.modelo.repository.OpinionArticuloRepository;

@Service
public class OpinionArticuloServiceImpl implements OpinionArticuloService{

	@Autowired
	private OpinionArticuloRepository oarepository;
	
	@Override
	public List<OpinionArticulo> buscarPorUsuario(int idUsuario) {
		return oarepository.findByUsuario_IdUsuario(idUsuario);
	}

	@Override
	public List<OpinionArticulo> buscarPorArticulo(int idArticulo) {
		return oarepository.findByArticulo_IdArticulo(idArticulo);
	}

	@Override
	public OpinionArticulo alta(OpinionArticulo opinionArticulo) {
		try {
			if (oarepository.existsById(opinionArticulo.getIdOpinion()))
				return null;
			else {
				return oarepository.save(opinionArticulo);
			}
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String eliminar(int idOpinion) {
		try {
			if (oarepository.existsById(idOpinion)) {
				oarepository.deleteById(idOpinion);
				return "1";
			} else
				return "0";
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public OpinionArticulo modificar(OpinionArticulo opinionArticulo) {
		try {
			if (oarepository.existsById(opinionArticulo.getIdOpinion())) {
				return oarepository.save(opinionArticulo);
			} else
				return null;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
