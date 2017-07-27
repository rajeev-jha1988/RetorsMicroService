/**
 * 
 */
package com.retors.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retors.dao.Dat01aSalesDao;
import com.retors.model.Dat01aSales;

/**
 * @author rajeev.jha
 *
 */
@Repository
public class Dat01aSalesDaoImpl extends UnivDAOAbstractImpl<Dat01aSales,String> implements Dat01aSalesDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	protected Class<Dat01aSales> getModelClass() {
		return Dat01aSales.class;
	}

}
