package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "aviso", schema = "avisos")
@SequenceGenerator(name = "seq_aviso", sequenceName = "seq_aviso", allocationSize = 1, initialValue = 1)
public class Aviso implements Serializable, Comparable<Aviso> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aviso")
	private Integer idAviso;

	@ManyToOne
	@JoinColumn(name = "idTipoParada")
	private TipoParada tipoParada;

	@ManyToOne
	@JoinColumn(name = "idSistema")
	private Sistema sistema;
	
	private Date dataEvento;
	private Date dataRetorno;
	private String avisoTexto;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aviso other = (Aviso) obj;
		if (idAviso == null) {
			if (other.idAviso != null)
				return false;
		} else if (!idAviso.equals(other.idAviso))
			return false;
		return true;
	}

	@Override
	public int compareTo(Aviso o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAviso == null) ? 0 : idAviso.hashCode());
		return result;
	}
}
