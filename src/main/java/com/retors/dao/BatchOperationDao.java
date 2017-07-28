/**
 * 
 */
package com.retors.dao;

import java.util.List;

/**
 * @author rajeev.jha
 *
 */
public interface BatchOperationDao  {
	public void saveBatch(List<?> models);

}
