package cacicboot.cacicboot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Revision")
public class Revision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_revision;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private Date fecha_creacion;
	

	@ManyToOne
	@JoinColumn(name ="fk_evaluador")
	private Usuario evaluador;
	@ManyToOne
	@JoinColumn(name ="fk_trabajo")
	private Trabajo trabajo;
	
	public Revision() {}
	public Revision(Usuario usuario,Trabajo trabajo) {
		this.id_revision = null;
		this.estado = "Pendiente";
		this.fecha_creacion = new Date(System.currentTimeMillis());
		this.evaluador = usuario;
		this.trabajo = trabajo;
	}
	
	public Revision(Integer idRevision, String estado, Date fechaCreacion, Usuario evaluador, Trabajo trabajo) {
		this.id_revision = idRevision;
		this.estado = estado;
		this.fecha_creacion = fechaCreacion;
		this.evaluador = evaluador;
		this.trabajo = trabajo;
	}

	public Integer getIdRevision() {
		return id_revision;
	}
	public void setIdRevision(Integer idRevision) {
		this.id_revision = idRevision;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaCreacion() {
		return fecha_creacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fecha_creacion = fechaCreacion;
	}
	public Usuario getEvaluador() {
		return evaluador;
	}
	public void setEvaluador(Usuario evaluador) {
		this.evaluador = evaluador;
	}
	public Trabajo getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
}
