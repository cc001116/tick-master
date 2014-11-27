package cn.flower.tick.persist;


import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;


/**
 * DAO�㹫��������װ   
 * �ӿ�����DAO�����е�����;
 * @FileName ICommonDao.java
 * @author ChenCheng
 * @version 1.0
 * @Date 2014-11-27 ����2:40:11
 * @param <T> ������;
 */
public interface ICommonDao<T> {
	/**
	 * save ʵ�����;
	 * @param entity ʵ�����;
	 * @return 
	 */
	void save(T entity);
	
	/**
	 * update ʵ�����
	 * @param entity ʵ�����;
	 */
	void update(T entity);
	/**
	 * SQL ��ʽ����
	 * @param sql
	 * @param params
	 */
	void update(String sql, Object...values); 
	
	/**
	 * ��������
	 * @param entity
	 */
	void saveOrUpdate(T entity);
	
	/**
	 * ������������
	 * @param entities
	 */
	void saveOrUpdateAll(Collection<T> entities) ;
	
	/**
	 * ����ָ��ID�������Ϣ;
	 * @param id ʵ������ţ�����ΪSerializable; Integer,String �ȶ�ʵ����Serializable�ӿ�;
	 * @return ���ط���������<T>�Ͷ���;
	 */
	T findObjectById(Serializable id);
	
	/**
	 * ɾ��ָ��ID�Ķ������Ϣ;
	 * @param ids Ҫɾ���Ķ���ID����;
	 */	
	void deleteObjectByIds(Serializable... ids);
	
	/**
	 * ɾ�������е�����;
	 * @param collection  Ҫɾ���Ķ���ļ��ϣ�һ��Ϊlist��; 
	 */
	void deleteObjectByCollection(Collection<T> collection);
	
	/**
	 * ���ҷ�������������;
	 * @param whereSql  ����SQL�� where�����Ӿ���and�Ӿ���ַ�������ʽΪ����AND id = ? AND name = ?��;
	 * 
	 * @param params	���SQL�����ռλ��("?")�Ĳ���;
	 */
	T findObjectByHql(String whereSql,Object...params);

	/**
	 * ���ҷ�������������
	 * @param sql	��׼sql���
	 * @param params	���SQL�����ռλ���ġ���������
	 * @return
	 */
	T findObjectBySql(String sql, Object...params);
	
	/**
	 * ���ҷ�������������;
	 * @param whereSql  ����SQL�� where�����Ӿ���and�Ӿ���ַ�������ʽΪ����AND id = ? AND name = ?��;
	 * 
	 * @param params	���SQL�����ռλ��("?")�Ĳ���;
	 * ����Object[] params = {1,"chen"};
	 * "WHERE 1 = 1 AND id = ? AND name = ?" 
	 * �����Զ�ͨ��query.setParameter(i, params[i])��˳�����
	 * 
	 * @param orderMap  ��֯SQL��ORDER��BY���Ӿ������; 
	 * ��:  LinkedHashMap<String , String> map = new LinkedHashMap<String, String>();
	 * map.put("date","desc");�����Զ�������֯�ɣ���ORDER BY date desc����ʽ���ַ���;
	 * 
	 * @return Collection ���󼯺�;
	 */
	Collection<T> findCollectionByHql(String whereSql,
			final Object[] params, LinkedHashMap<String, String> orderMap);
	
	/**
	 * �Ա�׼SQL��ʽ��ѯ������������
	 * @param sql
	 * @param params
	 * @return
	 */
	Collection<T> findCollectionBySql(String sql, final Object[] params);
}
