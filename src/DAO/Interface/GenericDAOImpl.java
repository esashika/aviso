package DAO.Interface;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@SuppressWarnings("unchecked")
public class GenericDAOImpl<T, PK> implements GenericDAO<T, PK> {
	@PersistenceContext(unitName="jpaEclipse")
    protected EntityManager entityManager;
 
	@Transactional(Transactional.TxType.REQUIRED)
    public void persist(T entity) {
        entityManager.persist(entity);
    }
	
	public void persistList(List<T> entity){
		for (T t : entity) {
			System.out.println(t);
			//entityManager.persist(t);
		}
	}
 
	@Transactional(Transactional.TxType.REQUIRED)
    public void merge(T entity) {
        entity = entityManager.merge(entity);
    }
	@Transactional(Transactional.TxType.REQUIRED)
    public void remove(T entity) {
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
    }
	@Transactional(Transactional.TxType.REQUIRED)
    public void removeById(PK id) {
        T entity = getById(id);
        entityManager.remove(entity);
    }
	
    public T getById(PK id) {
        return entityManager.find(getTypeClass(), id);
    }
 
    @Transactional(Transactional.TxType.REQUIRED)
    public Collection<T> findAll(String NomeDaEntidade) {
        return entityManager.createQuery("FROM " + NomeDaEntidade)
                .getResultList();
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public Query createQuery(String query, Object... parameters) {
        Query q = entityManager.createQuery(query);
 
        for (int i = 1; i <= parameters.length; i++) {
            q.setParameter(i, parameters[i]);
        }
         
        return q;
    }
    @Transactional(Transactional.TxType.REQUIRED)
    private Class<T> getTypeClass() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }}