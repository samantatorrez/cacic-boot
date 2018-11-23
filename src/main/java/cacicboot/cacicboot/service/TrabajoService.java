package cacicboot.cacicboot.service;

import java.util.List;

import cacicboot.cacicboot.dto.TrabajoDTO;
import cacicboot.cacicboot.entity.Trabajo;

public interface TrabajoService {
	public List<Trabajo> obtenerListaDeTrabajosPorAutor(Integer idAutor);
}
