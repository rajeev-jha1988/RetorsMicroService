/**
 * 
 */
package com.retors.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retors.dao.Mdt02EntityDao;
import com.retors.model.Mdt02Entity;

/**
 * @author rajeev.jha
 *
 */
@Repository
public class Mdt02EntityDaoImpl extends UnivDAOAbstractImpl<Mdt02Entity, String> implements Mdt02EntityDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EntityManager entityManger;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManger;
	}
	@Override
	protected Class<Mdt02Entity> getModelClass() {
		return Mdt02Entity.class;
	}
	
	

}
