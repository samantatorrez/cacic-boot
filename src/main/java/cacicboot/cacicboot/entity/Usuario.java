package cacicboot.cacicboot.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id_usuario;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Rol rol;
	@Column(nullable = false)
	private String lugar_trabajo;
	@Column(nullable = false)
	private String nombre_usuario;
	@Column(nullable = false)
	private String contrasenia;

	private String temas;
	private Date fecha_nac;
	private String domicilio;
	private int cod_postal;
	
	
	@OneToMany(mappedBy="evaluador", cascade = CascadeType.REMOVE, orphanRemoval=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Revision> revisiones;
	@OneToMany(mappedBy="autor", cascade = CascadeType.REMOVE, orphanRemoval=true)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<Trabajo> trabajos;

	public Usuario() {
		this.id_usuario = null;
		this.nombre = "";
		this.apellido = "";
		this.rol = Rol.autor;
		this.lugar_trabajo = "";
		this.nombre_usuario = "root";
		setContrasenia("1234");
		this.temas = "";
		this.fecha_nac = null;
		this.domicilio = "";
		this.cod_postal = -1;
		this.revisiones = new ArrayList<Revision>();
		this.trabajos = new ArrayList<Trabajo>();
	}

	public Usuario( String nombre, String apellido, Rol rol, String lugarTrabajo, String nombreUsuario,
			String contrasenia, String temas, Date fechaNac, String domicilio, int codPostal, List<Revision> revisiones,
			List<Trabajo> trabajos) {
		this.id_usuario = null;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.lugar_trabajo = lugarTrabajo;
		this.nombre_usuario = nombreUsuario;
		setContrasenia(contrasenia);
		this.temas = temas;
		this.fecha_nac = fechaNac;
		this.domicilio = domicilio;
		this.cod_postal = codPostal;
		this.revisiones = revisiones;
		this.trabajos = trabajos;
	}
	public Integer getIdUsuario() {
		return id_usuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.id_usuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getLugarTrabajo() {
		return lugar_trabajo;
	}
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugar_trabajo = lugarTrabajo;
	}
	public String getNombreUsuario() {
		return nombre_usuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombre_usuario = nombreUsuario;
	}
	public String getContrasenia() {
		return this.contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor ();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);
		this.contrasenia = passwordEncryptor.encryptPassword(contrasenia);
	}
	public String getTemas() {
		return temas;
	}
	public void setTemas(String temas) {
		this.temas = temas;
	}
	public Date getFechaNac() {
		return fecha_nac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fecha_nac = fechaNac;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getCodPostal() {
		return cod_postal;
	}
	public void setCodPostal(int codPostal) {
		this.cod_postal = codPostal;
	}
	
	public List<Revision> getRevisiones() {
		return revisiones;
	}
	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}
	public void addRevisiones(Revision revision) {
		this.revisiones.add(revision);
	}
	public List<Trabajo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	public void addTrabajos(Trabajo trabajo) {
		this.trabajos.add(trabajo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + cod_postal;
		result = prime * result + ((contrasenia == null) ? 0 : contrasenia.hashCode());
		result = prime * result + ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((fecha_nac == null) ? 0 : fecha_nac.hashCode());
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		result = prime * result + ((lugar_trabajo == null) ? 0 : lugar_trabajo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombre_usuario == null) ? 0 : nombre_usuario.hashCode());
		result = prime * result + ((revisiones == null) ? 0 : revisiones.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + ((temas == null) ? 0 : temas.hashCode());
		result = prime * result + ((trabajos == null) ? 0 : trabajos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cod_postal != other.cod_postal)
			return false;
		if (contrasenia == null) {
			if (other.contrasenia != null)
				return false;
		} else if (!contrasenia.equals(other.contrasenia))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (fecha_nac == null) {
			if (other.fecha_nac != null)
				return false;
		} else if (!fecha_nac.toString().equals(other.fecha_nac.toString()))
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (lugar_trabajo == null) {
			if (other.lugar_trabajo != null)
				return false;
		} else if (!lugar_trabajo.equals(other.lugar_trabajo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombre_usuario == null) {
			if (other.nombre_usuario != null)
				return false;
		} else if (!nombre_usuario.equals(other.nombre_usuario))
			return false;
		if (revisiones == null) {
			if (other.revisiones != null)
				return false;
		} else if (!revisiones.equals(other.revisiones) && !revisiones.isEmpty())
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (temas == null) {
			if (other.temas != null)
				return false;
		} else if (!temas.equals(other.temas))
			return false;
		if (trabajos == null) {
			if (other.trabajos != null)
				return false;
		} else if (!trabajos.equals(other.trabajos) && !trabajos.isEmpty())
			return false;
		return true;
	}
	
}
