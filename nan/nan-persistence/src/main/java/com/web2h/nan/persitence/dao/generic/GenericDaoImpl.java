package com.web2h.nan.persitence.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.web2h.nan.persitence.dao.utils.Page;

/**
 * Generic DAO abstract class.
 * 
 * @author Web2h
 *
 * @param <E> Entity class
 * @param <PK> Table primary key class
 */
public abstract class GenericDaoImpl<E, PK extends Serializable> implements GenericDao<E, PK> {

	private Class<E> clazz;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected GenericDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		clazz = (Class) parameterizedType.getActualTypeArguments()[0];
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public PK create(E entity) {
		return (PK) getCurrentSession().save(entity);
	}

	@Override
	public void delete(E entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public E read(PK pk) {
		try {
			return (E) getCurrentSession().get(clazz, pk);
		} catch (IllegalArgumentException iae) {
			return null;
		}
	}

	@Override
	public E readAndRefresh(PK pk) {
		E entity = (E) getCurrentSession().get(clazz, pk);
		getCurrentSession().refresh(entity);
		return entity;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> readAll() {
		Criteria criteria = createCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> readAll(Page page) {
		Criteria criteria = createCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		if (page != null) {
			criteria.setFirstResult(page.getFirstResult());
			criteria.setMaxResults(page.getMaxResult());
		}
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> readByCriteria(Criterion criterion) {
		Criteria criteria = createCriteria();
		criteria.add(criterion);
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> readByCriterias(Criterion... criterions) {
		Criteria criteria = createCriteria();
		if (criterions != null) {
			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
		}
		return criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> readByField(String field, Object value) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq(field, value));
		return criteria.list();
	}

	@Override
	public void update(E entity) {
		getCurrentSession().saveOrUpdate(entity);
		getCurrentSession().flush();
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected Criteria createCriteria() {
		return getCurrentSession().createCriteria(clazz);
	}

	protected DetachedCriteria createDetachedCriteria() {
		return DetachedCriteria.forClass(clazz);
	}
}