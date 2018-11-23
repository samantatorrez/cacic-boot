package cacicboot.cacicboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cacicboot.cacicboot.controller.DBManager;
import cacicboot.cacicboot.dto.TrabajoDTO;
import cacicboot.cacicboot.entity.Revision;
import cacicboot.cacicboot.entity.Trabajo;
import cacicboot.cacicboot.service.TrabajoService;

@Service
public class TrabajoServiceImpl implements TrabajoService{
	
	public List<Trabajo> obtenerListaDeTrabajosPorAutor(Integer idAutor){
		   DBManager dbManager=new DBManager();
			List trabajo =  dbManager.getRevisionDao().getTrabajosByAutor(idAutor);
			return trabajo;
	}
}
