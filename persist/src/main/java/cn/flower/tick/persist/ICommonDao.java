package cn.flower.tick.persist;


import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * DAO层公共方法封装   
 * 接口描述DAO所具有的能力;
 * @FileName ICommonDao.java
 * @author ChenCheng
 * @version 1.0
 * @Date 2014-11-27 下午2:40:11
 * @param <T> 范型类;
 */
public interface ICommonDao<T> {
	/**
	 * save 实体对象;
	 * @param entity 实体对象;
	 * @return 
	 */
	void save(T entity);
	
	/**
	 * update 实体对象
	 * @param entity 实体对象;
	 */
	void update(T entity);
	/**
	 * SQL 方式更新
	 * @param sql
	 * @param params
	 */
	void update(String sql, Object...values); 
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	void saveOrUpdate(T entity);
	
	/**
	 * 批量保存或更新
	 * @param entities
	 */
	void saveOrUpdateAll(Collection<T> entities) ;
	
	/**
	 * 查找指定ID对象的信息;
	 * @param id 实体对象编号，类型为Serializable; Integer,String 等都实现了Serializable接口;
	 * @return 返回符合条件的<T>型对象;
	 */
	T findObjectById(Serializable id);
	
	/**
	 * 删除指定ID的对象的信息;
	 * @param ids 要删除的对象ID数组;
	 */	
	void deleteObjectByIds(Serializable... ids);
	
	/**
	 * 删除集合中的数据;
	 * @param collection  要删除的对象的集合（一般为list）; 
	 */
	void deleteObjectByCollection(Collection<T> collection);
	
	/**
	 * 查找符合条件的数据;
	 * @param whereSql  描述SQL中 where条件子句中and子句的字符串：形式为：“AND id = ? AND name = ?”;
	 * 
	 * @param params	填充SQL语句中占位符("?")的参数;
	 */
	T findObjectByHql(String whereSql,Object...params);

	/**
	 * 查找符合条件的数据
	 * @param sql	标准sql语句
	 * @param params	填充SQL语句中占位符的“？”参数
	 * @return
	 */
	Object findObjectBySql(String sql, Object...params);
	
	/**
	 * 查找符合条件的数据;
	 * @param whereSql  描述SQL中 where条件子句中and子句的字符串：形式为：“AND id = ? AND name = ?”;
	 * 
	 * @param params	填充SQL语句中占位符("?")的参数;
	 * 例：Object[] params = {1,"chen"};
	 * "WHERE 1 = 1 AND id = ? AND name = ?" 
	 * 程序自动通过query.setParameter(i, params[i])按顺序填充
	 * 
	 * @param orderMap  组织SQL中ORDER　BY　子句的内容; 
	 * 例:  LinkedHashMap<String , String> map = new LinkedHashMap<String, String>();
	 * map.put("date","desc");程序将自动将其组织成：“ORDER BY date desc”样式的字符串;
	 * 
	 * @return Collection 对象集合;
	 */
	Collection<T> findCollectionByHql(String whereSql,
			final Object[] params, LinkedHashMap<String, String> orderMap);
	
	/**
	 * 以标准SQL方式查询符合条件数据
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List findCollectionBySql(String sql, final Object...params);
}
