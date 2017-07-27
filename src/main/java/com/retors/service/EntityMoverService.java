/**
 * 
 */
package com.retors.service;

import com.retors.model.Dat01aSales;
import com.retors.model.Mdt01Sales;
import com.retors.model.Mdt02Entity;

/**
 * @author rajeev.jha
 *
 */
public interface EntityMoverService {

	public void saveDat01aSales(Dat01aSales dat01aSales );
	public void saveMdt01Sales(Mdt01Sales dat01aSales );
	public void saveMdt02Entity(Mdt02Entity dat01aSales );
}
