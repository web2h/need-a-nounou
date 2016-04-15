package com.web2h.nan.persitence.dao.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.web2h.nan.persitence.dao.utils.Page;

/**
 * Generic DAO interface.
 *
 * @author Web2h
 *
 * @param <E>
 *            Entity class
 * @param <PK>
 *            Table primary key class
 */
public interface GenericDao<E, PK extends Serializable> {

	/**
	 * Creates (and persists) a new entity in the database.
	 *
	 * @param entity
	 *            The new entity to persist
	 * @return The primary key of the inserted object
	 */
	PK create(E entity);

	/**
	 * Deletes the provided entity from the database.
	 *
	 * @param entity
	 *            Entity to delete
	 */
	void delete(E entity);

	/**
	 * Gets a element based on its id.
	 *
	 * @param pk
	 *            The primary key of the requested object
	 * @return The retrieved object, null if none has been found
	 */
	E read(PK pk);

	/**
	 * Gets all the elements from the table.
	 *
	 * @return The list of elements
	 */
	List<E> readAll();

	/**
	 * Gets all the elements from the table in the range defined by the given
	 * page.
	 *
	 * @param page
	 *            Page info
	 * @return The list of elements
	 */
	List<E> readAll(Page page);

	/**
	 * Gets a element based on its id after refreshing it
	 *
	 * @param pk
	 *            The primary key of the requested object
	 * @return The retrieved object, null if none has been found
	 */
	E readAndRefresh(PK pk);

	/**
	 * Gets a subset of the table based on the given criterion.
	 *
	 * @param criterion
	 *            Filter
	 * @return The subset of elements
	 */
	List<E> readByCriteria(Criterion criterion);

	/**
	 * Gets a subset of the table based on the given list of criterions.
	 *
	 * @param criterions
	 *            Filters
	 * @return The subset of elements
	 */
	List<E> readByCriterias(Criterion... criterions);

	/**
	 * Gets a subset of a table based on the given field condition (only
	 * equality).
	 *
	 * @param field
	 *            Field name
	 * @param value
	 *            Field value
	 * @return The subset of elements
	 */
	List<E> readByField(String field, Object value);

	/**
	 * Updates the provided entity in the database.
	 *
	 * @param entity
	 *            The entity to update
	 */
	void update(E entity);
}