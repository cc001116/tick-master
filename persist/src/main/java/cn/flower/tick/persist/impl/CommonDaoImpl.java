package cn.flower.tick.persist.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.flower.tick.persist.ICommonDao;

/**
 * DAO层公共方法封装 继承HibernateDaoSupport 是为了使用其HibernateTemplate属性;
 * 
 * @FileName CommonDaoImpl.java
 * @author ChenCheng
 * @param <T>
 *            范型化参数
 */

public abstract class CommonDaoImpl<T> implements ICommonDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	protected Class entityClass = getActualType();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Class getActualType() {
		Type superType = this.getClass().getGenericSuperclass();

		if (superType instanceof Class) {
			superType = ((Class) superType).getGenericSuperclass();
		}

		if (superType instanceof ParameterizedType) {
			return (Class<T>) ((ParameterizedType) superType)
					.getActualTypeArguments()[0];
		} else {
			return null;
		}
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 *  获取表名（注解方式配表名时特殊处理）
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getTableName() {
		String tableName = null;
		@SuppressWarnings("unchecked")
		Table table = (Table) entityClass.getAnnotation(Table.class);
		if(table != null && table.name() != null)  {
			tableName = table.name();
		} else {
			tableName = entityClass.getSimpleName();
		}
		return tableName;
	}
	
	
	
	/**
	 * 保存一个实体；
	 * 
	 * @param entity
	 *            实体对象;
	 */
	public void save(T entity) {
		this.getSession().save(entity);
	}

	/**
	 * 更新;
	 */
	public void update(T entity) {
		this.getSession().update(entity);
	}

	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<T> entities) {
		for (T entity : entities) {
			saveOrUpdate(entity);
		}
	}

	/**
	 * Sql 方式更新
	 * 
	 * @param sql
	 * @param params
	 */
	public void update(String sql, Object... params) {
		getSqlQuery(this.getSession(), sql, params).executeUpdate();
	}

	/**
	 * 依据id查找
	 * 
	 * @param id
	 *            要查找的id
	 */
	@SuppressWarnings("unchecked")
	public T findObjectById(Serializable id) {
		return (T) this.getSession().get(entityClass, id);
	}

	/**
	 * 依据id删除对象;
	 * 
	 * @param id
	 *            要删除的对象的id
	 */
	public void deleteObjectByIds(Serializable... ids) {
		for (Serializable id : ids) {
			Object entity = this.getSession().get(entityClass, id);
			this.getSession().delete(entity);
		}
	}

	/**
	 * 删除对象集合
	 */
	public void deleteObjectByCollection(Collection<T> collection) {
		for (T entity : collection) {
			this.getSession().delete(entity);
		}
	}

	/**
	 * HQL方式查询符合条件的对象
	 */
	public T findObjectByHql(String whereSql, Object... params) {
		List<T> list = (List<T>) findCollectionByHql(whereSql, params, null);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * 标准SQL方式查询符合条件的对象
	 */
	@SuppressWarnings("rawtypes")
	public Object findObjectBySql(String sql, Object... params) {
		List list = (List) findCollectionBySql(sql, params);
		return list.size() > 0 ? list.get(0) : null;
	}

	/**
	 * HQL方式查询符合条件的集合
	 */
	@SuppressWarnings("unchecked")
	public Collection<T> findCollectionByHql(String whereSql,
			final Object[] params, LinkedHashMap<String, String> orderMap) {
		final String hql = createSql(whereSql, orderMap);
		return getQuery(this.getSession(), hql, params).list();

	}

	/**
	 * 标准SQL方式查询符合条件的集合
	 */
	
	
	@SuppressWarnings("rawtypes")
	public List findCollectionBySql(final String sql,
			final Object...params) {
		List list = getSqlQuery(this.getSession(), sql, params).list();
		return list;
	}

	private String createSql(String whereSql,
			LinkedHashMap<String, String> orderMap) {
		String baseSql = "SELECT o FROM " +  entityClass.getSimpleName()
				+ " o ";
		String orderBy = this.orderBy(orderMap);// 组织排序的条件
		return new StringBuffer(60).append(baseSql)
				.append(whereSql == null ? "" : whereSql).append(orderBy)
				.toString();
	}

	protected Query getQuery(Session session, String sql, Object... params) {
		Query query = session.createQuery(sql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query;
	}

	private SQLQuery getSqlQuery(Session session, String sql, Object... params) {
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		for (int i = 0; params != null && i < params.length; i++) {
			sqlQuery.setParameter(i, params[i]);
		}
		return sqlQuery;
	}

	/** 组织排序的条件 */
	private String orderBy(LinkedHashMap<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			buffer.append(" ORDER BY ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(" " + map.getKey() + " " + map.getValue() + ",");
			}
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}

}
