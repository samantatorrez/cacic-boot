package cacicboot.cacicboot.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Trabajo")
public class Trabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public
	 Integer id_trabajo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public
	 Categoria categoria;
	@Column(nullable = false)
	public
	 String palabras_claves;
	
	@ManyToOne
	@JoinColumn(name ="fk_autor")
	public
	 Usuario autor;
	
	@OneToMany(mappedBy="trabajo", cascade = CascadeType.REMOVE, orphanRemoval=true)
	@NotFound(action=NotFoundAction.IGNORE)
	 List<Revision> revisiones;

	public Trabajo() {}
	
	public Trabajo(Usuario autor) {
		this.id_trabajo = null;
		this.categoria = Categoria.articulo;
		this.palabras_claves = "";
		this.autor = autor;
		this.revisiones = new ArrayList<Revision>();
	}
	
	public Trabajo(Categoria categoria, String palabrasClaves, Usuario autor, List<Revision> revisiones) {
		this.id_trabajo = null;
		this.categoria = categoria;
		this.palabras_claves = palabrasClaves;
		this.autor = autor;
		this.revisiones = revisiones;
	}

	public Integer getIdTrabajo() {
		return id_trabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.id_trabajo = idTrabajo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getPalabrasClaves() {
		return palabras_claves;
	}

	public void setPalabrasClaves(String palabrasClaves) {
		this.palabras_claves = palabrasClaves;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((id_trabajo == null) ? 0 : id_trabajo.hashCode());
		result = prime * result + ((palabras_claves == null) ? 0 : palabras_claves.hashCode());
		result = prime * result + ((revisiones == null) ? 0 : revisiones.hashCode());
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
		Trabajo other = (Trabajo) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.getIdUsuario().equals(other.autor.getIdUsuario()))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (id_trabajo == null) {
			if (other.id_trabajo != null)
				return false;
		} else if (!id_trabajo.equals(other.id_trabajo))
			return false;
		if (palabras_claves == null) {
			if (other.palabras_claves != null)
				return false;
		} else if (!palabras_claves.equals(other.palabras_claves))
			return false;
		return true;
	}
	
}
