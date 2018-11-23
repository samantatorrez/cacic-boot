package cacicboot.cacicboot.db;

import java.util.List;

import cacicboot.cacicboot.entity.Usuario;


public interface UsuarioDao {
	
	public Integer altaUsuario(Usuario usuario);
	public Usuario getUsuario(Integer id);
	public List<Usuario> getUsuarios();
	public void bajaUsuario(Integer id);
	public void eliminarDatos();
	
}
