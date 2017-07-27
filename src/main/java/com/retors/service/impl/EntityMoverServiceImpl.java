/**
 * 
 */
package com.retors.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retors.dao.Dat01aSalesDao;
import com.retors.dao.Mdt01SalesDao;
import com.retors.dao.Mdt02EntityDao;
import com.retors.model.Dat01aSales;
import com.retors.model.Mdt01Sales;
import com.retors.model.Mdt02Entity;
import com.retors.service.EntityMoverService;

/**
 * @author rajeev.jha
 *
 */
@Service
@Transactional
public class EntityMoverServiceImpl implements EntityMoverService {
	
	@Autowired
	private Dat01aSalesDao dat01aSalesDao;
	@Autowired
	private Mdt01SalesDao  mdt01SalesDao;
	@Autowired
	private Mdt02EntityDao  mdt02EntityDao;
	
	@Override
	public void saveDat01aSales(Dat01aSales dat01aSales) {
		dat01aSalesDao.createRecord(dat01aSales);
	}

	@Override
	public void saveMdt01Sales(Mdt01Sales mdt01Sales) {
		mdt01SalesDao.createRecord(mdt01Sales);
	}
	
	@Override
	public void saveMdt02Entity(Mdt02Entity mdt02Entity) {
		mdt02EntityDao.createRecord(mdt02Entity);
	}

	@Override
	public Mdt01Sales findMdtSales(String id) {
		Mdt01Sales mdt01Sales= mdt01SalesDao.findByPrimaryKey(id);
		return mdt01Sales;
	}

}
