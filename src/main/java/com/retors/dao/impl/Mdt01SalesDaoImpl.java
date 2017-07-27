/**
 * 
 */
package com.retors.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.retors.dao.Mdt01SalesDao;
import com.retors.model.Mdt01Sales;

/**
 * @author rajeev.jha
 *
 */
@Repository
public class Mdt01SalesDaoImpl extends UnivDAOAbstractImpl<Mdt01Sales, String> implements Mdt01SalesDao {
	
	private static final long serialVersionUID = 1L;
	private EntityManager entityManger;
	
	@Override
	protected EntityManager getEntityManager() {
		return this.entityManger;
	}

	@Override
	protected Class<Mdt01Sales> getModelClass() {
		return Mdt01Sales.class;
	}

}
