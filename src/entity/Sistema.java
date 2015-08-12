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
@Table(name = "sistema", schema = "avisos")
@SequenceGenerator(name = "seq_sistema", sequenceName = "seq_sistema", allocationSize = 1, initialValue = 1)
public class Sistema implements Serializable, Comparable<Sistema>, SampleEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sistema")
	private Integer idSistema;
	
	private String nomeSistema;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idSistema;
	}

	@Override
	public int compareTo(Sistema o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)  
            return true;  
        if (obj == null)  
            return false;  
        if (getClass() != obj.getClass())  
            return false;  
        Sistema other = (Sistema) obj;  
        if (idSistema == null) {  
            if (other.idSistema != null)  
                return false;  
        } else if (!idSistema.equals(other.idSistema))  
            return false;  
        return true;  
	}

	@Override
	public int hashCode() {
		final int prime = 31;  
        int result = 1;  
        result = prime * result + ((idSistema == null) ? 0 : idSistema.hashCode());  
        return result;  
	}
}
