package DAO.Interface;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

public interface GenericDAO<T, PK> {
    void persist(T entity);
    
    void persistList(List<T> entity);
 
    void merge(T entity);
 
    void remove(T entity);
 
    void removeById(PK id);
 
    T getById(PK id);
 
    Collection<T> findAll(String NomeDaEntidade);
     
    Query createQuery(String query, Object... parameters);
}