/**
 * 
 */
package com.retors.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retors.dao.BatchOperationDao;

/**
 * @author rajeev.jha
 *
 */
@Repository
public class BatchOperationDaoImpl implements BatchOperationDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveBatch(List<?> models) {
		int count=0;
		for (Object entity : models) {
			entityManager.persist(entity);
			if (count % 20 == 0) {
				entityManager.flush();
				entityManager.clear();
			}
			count++;
		}
		entityManager.flush();
		entityManager.clear();
	}
}
