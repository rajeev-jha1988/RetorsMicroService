package com.retors.dao.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.retors.dao.UnivDAO;



/**
 * Abstract class implementing UnivDAO<T, E> interface, generic methods which
 * were to be defined in each class implementing the UnivDAO<T, E> interface
 * have been defined here. Classes extending this abstract class need to provide
 * the autowired HibernateUtil object and the respective hibernate Model class.
 * 
 * @param <T>
 *            Model class
 * @param <E>
 *            Primary key class
 * 
 *  @author whiteTiger
 * 
 */

public abstract class UnivDAOAbstractImpl<T, E extends Serializable> implements	UnivDAO<T, E> {

	private static final long serialVersionUID = -3898701016758227547L;

	/**
	 * Accessor method for hibernateUtil
	 * 
	 * @return Autowired HibernateUtil object
	 */
	protected abstract EntityManager getEntityManager();
	
	@Autowired
	private EntityManager entityManager;


	/**
	 * Accessor method for Model class
	 * 
	 * @return Respective Model class
	 */
	protected abstract Class<T> getModelClass();

	@Override
	@SuppressWarnings("unchecked")
	public E createRecord(T model)  {
		E pk = null;
			Session session = getEntityManager().unwrap(Session.class);
			pk = (E) session.save(model);
		return pk;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void updateRecord(T model) {
		
		Session session = getEntityManager().unwrap(Session.class);
		model = (T) session.merge(model);
		session.saveOrUpdate(model);
	}

	@Override
	public void deleteRecord(T model)  {
		EntityManager em = getEntityManager();
		em.remove(em.contains(model)?model:em.merge(model));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll(int fetchSize, int fetchCount)  {
		List<T> returnList = new ArrayList<T>();
		Session session = getEntityManager().unwrap(Session.class);
		Query<T> managerQuery = session.createQuery("from " + getModelClass().getSimpleName() + "t");
		managerQuery.setMaxResults(fetchSize);
		managerQuery.setFirstResult(fetchSize * fetchCount);
		returnList = managerQuery.list();
		return returnList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findByPrimaryKey(E pk)  {
		T returnModel = null;
			Session session = getEntityManager().unwrap(Session.class);
			returnModel = (T) session.get(getModelClass(), pk);
		
		return returnModel;
	}
}

