package cacicboot.cacicboot.db;

import java.util.List;

import cacicboot.cacicboot.entity.Tema;

public interface TemaDao {

	public String altaTema(Tema tema);
	public Tema getTema(String palabra);
	public List<Tema> getTemas();
	public void bajaTema(String palabra);
	public void eliminarDatos();
	
}