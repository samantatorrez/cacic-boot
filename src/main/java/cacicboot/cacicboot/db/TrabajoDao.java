package cacicboot.cacicboot.db;

import java.util.List;

import cacicboot.cacicboot.entity.Trabajo;

public interface TrabajoDao {
	public Integer altaTrabajo(Trabajo trabajo);
	public Trabajo getTrabajo(Integer id);
	public List<Trabajo> getTrabajos();
	public void bajaTrabajo(Integer id);
	public void eliminarDatos();
	public List<Trabajo> getTrabajosCategoria(String string);
}