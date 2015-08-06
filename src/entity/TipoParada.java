package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tparada", schema = "avisos")
@SequenceGenerator(name = "tparada_seq", sequenceName = "tparada_seq", allocationSize = 1, initialValue = 1)
public class TipoParada implements Serializable, Comparable<TipoParada>,SampleEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tparada_seq")
	private Integer idTipoParada;

	private String descparada;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        TipoParada other = (TipoParada) obj;  
        if (idTipoParada == null) {  
            if (other.idTipoParada != null)  
                return false;  
        } else if (!idTipoParada.equals(other.idTipoParada))  
            return false;  
        return true;  
	}

	@Override
	public int compareTo(TipoParada o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;  
        int result = 1;  
        result = prime * result + ((idTipoParada == null) ? 0 : idTipoParada.hashCode());  
        return result;  
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTipoParada;
	}

}
