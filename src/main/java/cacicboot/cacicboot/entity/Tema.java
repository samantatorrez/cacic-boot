package cacicboot.cacicboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Tema")
public class Tema {
	
	@Id
	private String palabra;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoPalabra tipo;
	
	/**
	 * @param palabra
	 * @param tipo
	 */
	public Tema(String palabra, TipoPalabra tipo) {
		this.palabra = palabra;
		tipo = tipo;
	}

	/**
	 * 
	 */
	public Tema() {
	}

	/**
	 * @return the palabra
	 */
	public String getPalabra() {
		return palabra;
	}

	/**
	 * @param palabra the palabra to set
	 */
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	/**
	 * @return the tipo
	 */
	public TipoPalabra getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoPalabra tipo) {
		tipo = tipo;
	}
	
	
}