package com.demo.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.demo.common.DBConnector;
import com.demo.common.HbnUtil;
import com.demo.dao.dai.ActivityDAO;
import com.demo.entity.ActivityInfo;
import com.demo.entity.Member;

public class ActivityDAOImpl implements ActivityDAO{
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean addActivity(ActivityInfo ai) {

		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(ai);		//将对象放到了session的缓冲区中，没有开始执行操作
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean updateAvtivityAstatus(ActivityInfo ai) {

		String hql="UPDATE ActivityInfo SET astatus='已截止'  WHERE ano=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,ai.getAno());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean deleteActivity(ActivityInfo ai) {

		String hql="DELETE FROM ActivityInfo WHERE ano=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,ai.getAno());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public List<ActivityInfo> findAllActivity() {
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(ActivityInfo.class);
		crit.addOrder(Order.asc("ano"));
		List<ActivityInfo> list=crit.list();
		session.close();
		return list;
	}

	@Override
	public List<ActivityInfo> findActivityByAno(String ano) {
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(ActivityInfo.class);
		crit.add(Restrictions.eq("ano", ano));
		crit.addOrder(Order.asc("ano"));
		List<ActivityInfo> list=crit.list();
		session.close();
		return list;
	}

	@Override
	public List<ActivityInfo> findByCondition(Map<String, String> condition) {		//条件查询
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(ActivityInfo.class);
		Iterator<Entry<String,String>>iter=condition.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String,String> entry=iter.next();
			String key=entry.getKey();
			String value=entry.getValue();
			if("aname".equals(key)) {		//活动名称查询（模糊查询）
				criteria.add(Restrictions.like("aname",value,MatchMode.ANYWHERE));
			}
			if("atime".equals(key)) {		//活动名称查询
				criteria.add(Restrictions.like("atime",value,MatchMode.ANYWHERE));
			}
			if("astatus".equals(key)) {		//活动名称查询
				criteria.add(Restrictions.eq("astatus",value));
			}
		}
		criteria.addOrder(Order.desc("ano"));
		List <ActivityInfo> list=criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	

	@Override
	public ActivityInfo findActivity(String ano) {
		String hql="FROM ActivityInfo WHERE ano=?";
		ActivityInfo ai=new ActivityInfo();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, ano);
		List<ActivityInfo> list=query.list();
		for(int i=0;i<list.size();i++) {
			ai=list.get(i);
		}
		session.getTransaction().commit();
		session.close();
		return ai;
	}
}
