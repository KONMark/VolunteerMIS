package com.demo.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import com.demo.common.DBConnector;
import com.demo.common.HbnUtil;
import com.demo.dao.dai.ApplyDAO;
import com.demo.entity.ApplyList;

public class ApplyDAOImpl implements ApplyDAO{
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
	public boolean addApply(ApplyList al) {		//活动报名
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(al);		//将对象放到了session的缓冲区中，没有开始执行操作
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean updateApplyActionYes(ApplyList al) {		//确认报名
		String hql="UPDATE ApplyList SET action='是' WHERE apno=? AND aid=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,al.getApno());
		query.setParameter(1,al.getAid());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	
	public boolean updateApplyActionNo(ApplyList al) {		//拒绝报名
		String hql="UPDATE ApplyList SET action='否' WHERE apno=? AND aid=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,al.getApno());
		query.setParameter(1,al.getAid());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	
	public boolean updateApplyFeedback(ApplyList al) {		//反思反馈填写
		String hql="UPDATE ApplyList SET feedback=? WHERE apno=? AND aid=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,al.getFeedback());
		query.setParameter(1,al.getApno());
		query.setParameter(2,al.getAid());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	
	@Override
	public boolean deleteApply(ApplyList al) {		//删除报名信息
		String hql="DELETE ApplyList WHERE apno=? AND aid=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,al.getApno());
		query.setParameter(1,al.getAid());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public List<ApplyList> findAllApply() {
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(ApplyList.class);
		crit.addOrder(Order.asc("apno"));
		List<ApplyList> list=crit.list();
		session.close();
		return list;
	}

	@Override
	public List<ApplyList> findApplyByApno(String apno) {
		String hql="FROM ApplyList WHERE apno=? ORDER BY apno";
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, apno);
		List<ApplyList> list=query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	public List<ApplyList> findApplyByAid(String aid) {		//这里使用Hibernate框架的时候出现了bug，未能解决，先用JDBC代替
//		String hql="FROM ApplyList WHERE aid=? ORDER BY apno";
//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		Query query=session.createQuery(hql);
//		query.setParameter(0, aid);
//		List<ApplyList> list=query.list();
//		session.getTransaction().commit();
//		session.close();
//		return list;
		List<ApplyList> list=new ArrayList<ApplyList>();
		try {
			conn=DBConnector.getConnection();
			String sql="SELECT * FROM APPLYLIST WHERE aid=? ORDER BY apno";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				ApplyList al=new ApplyList();
				al.setApno(rs.getString(1));
				al.setAid(rs.getString(2));
				al.setName(rs.getString(3));
				al.setAname(rs.getString(4));
				al.setAction(rs.getString(5));
				al.setAsign(rs.getString(6));
				al.setFeedback(rs.getString(7));
				list.add(al);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ApplyList findApplyByApnoAid(String apno, String aid) {
		String hql="FROM ApplyList WHERE apno=? AND aid=? ORDER BY apno";
		ApplyList al=new ApplyList();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, apno);
		query.setParameter(1, aid);
		List<ApplyList> list=query.list();
		for(int i=0;i<list.size();i++) {
			al=list.get(i);
		}
		session.getTransaction().commit();
		session.close();
		return al;
	}

	@Override
	public boolean updateApplyAsign(ApplyList al) {
		String hql="UPDATE ApplyList SET asign='已签到' WHERE apno=? AND aid=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,al.getApno());
		query.setParameter(1,al.getAid());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean cancelApplyAsign(ApplyList al) {
		String hql="UPDATE ApplyList SET asign='未签到' WHERE apno=? AND aid=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,al.getApno());
		query.setParameter(1,al.getAid());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
}
