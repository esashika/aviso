package DAO.Interface;

import java.util.List;

import entity.Aviso;

public interface AvisoDAO extends GenericDAO<Aviso, Integer> {

	
	public List<Aviso> SearchAvisoByDateEventoAndDateReturn(String dataEventoM, String dataRetornoM);
}
