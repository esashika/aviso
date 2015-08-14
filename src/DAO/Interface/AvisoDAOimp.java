package DAO.Interface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Aviso;

public class AvisoDAOimp extends GenericDAOImpl<Aviso, Integer> implements
		Serializable, AvisoDAO {
	private static final long serialVersionUID = 1L;

	List<Aviso> listaDeAviso = new ArrayList<>();

	@PersistenceContext(unitName = "jpaEclipse")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Aviso> SearchAvisoByDateEventoAndDateReturn(String dataEventoM,
			String dataRetornoM) {
		listaDeAviso = entityManager.createQuery(
				"from Aviso a where a.dataEvento>='" + dataEventoM
						+ "' and a.dataRetorno<='" + dataRetornoM + "'")
				.getResultList();
		System.out.println(listaDeAviso.size());
		return listaDeAviso;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aviso> findAllByIdSystem(String idSistema) {
		return entityManager.createQuery(
				"FROM Aviso a where a.sistema.idSistema =" + idSistema)
				.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aviso> SearchAvisoByDateEventoAndDateReturnIdSystem(
			String dataEventoM, String dataRetornoM, String idSistema) {
		listaDeAviso = entityManager.createQuery(
				"from Aviso a where a.dataEvento>='" + dataEventoM
						+ "' and a.dataRetorno<='" + dataRetornoM + "'" + "and a.sistema.idSistema=" + idSistema)
				.getResultList();
		System.out.println(listaDeAviso.size());
		return listaDeAviso;
	}
}
