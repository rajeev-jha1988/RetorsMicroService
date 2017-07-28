/**
 * 
 */
package com.retors.service;

import java.util.List;

import com.retors.model.Mdt01Sales;

/**
 * @author rajeev.jha
 *
 */
public interface EntityMoverService {

/*	public void saveDat01aSales(Dat01aSales dat01aSales );
	public void saveMdt01Sales(Mdt01Sales dat01aSales );
	public void saveMdt02Entity(Mdt02Entity dat01aSales );*/
	
	public Mdt01Sales findMdtSales(String id );
	
	public void batchInsert(List<?> modelList );
}
