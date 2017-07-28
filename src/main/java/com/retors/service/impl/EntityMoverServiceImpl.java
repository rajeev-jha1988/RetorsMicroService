/**
 * 
 */
package com.retors.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retors.dao.BatchOperationDao;
import com.retors.dao.Mdt01SalesDao;
import com.retors.model.Mdt01Sales;
import com.retors.service.EntityMoverService;

/**
 * @author rajeev.jha
 *
 */
@Service
@Transactional
public class EntityMoverServiceImpl implements EntityMoverService {
	@Autowired
	private Mdt01SalesDao  mdt01SalesDao;
	@Autowired
	private BatchOperationDao batchOperationDao;

	@Override
	public Mdt01Sales findMdtSales(String id) {
		Mdt01Sales mdt01Sales= mdt01SalesDao.findByPrimaryKey(id);
		return mdt01Sales;
	}

	@Override
	public void batchInsert(List<?> modelList) {
		batchOperationDao.saveBatch(modelList);

	}
}
