package com.retors.dao;


import java.io.Serializable;
import java.util.List;



/**
 * @author whiteTiger
 * 
 */

public interface UnivDAO<T, E> extends Serializable {

	/**
	 * Generic method to create a tuple corresponding to the model
	 * 
	 * @param model
	 *            Model object
	 * @return Primary key of the created tuple
	 */
	E createRecord(T model) ;

	/**
	 * Generic method to update a tuple corresponding to the model
	 * 
	 * @param model
	 *            Model object
	 */
	void updateRecord(T model) ;

	/**
	 * Generic method to delete a tuple corresponding to the model
	 * 
	 * @param model
	 *            Model object
	 */
	void deleteRecord(T model)  ;

	/**
	 * Generic method to get models(tuples) based on fetchSize & fetchCount
	 * 
	 * @param fetchSize
	 *            Number of tuples to be fetched in a count
	 * @param fetchCount
	 *            Count of the fetch
	 * @return List of models(tuples) which have been fetched
	 */
	List<T> findAll(int fetchSize, int fetchCount) ;

	/**
	 * Generic method to get a model(tuple) based on primary key
	 * 
	 * @param pk
	 *            Primary key of the model
	 * @return Model(tuple) corresponding to the primary key
	 */
	T findByPrimaryKey(E pk) ;


}
