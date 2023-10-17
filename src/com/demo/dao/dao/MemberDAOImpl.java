package com.demo.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import com.demo.common.HbnUtil;
import com.demo.dao.dai.MemberDAO;
import com.demo.entity.Member;

public class MemberDAOImpl implements MemberDAO{
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
	public boolean addMember(Member mb) {		//添加学员信息
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(mb);		//将对象放到了session的缓冲区中，没有开始执行操作
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	@Override
	public boolean updateMemberPassword(Member mb) {		//修改密码
		String hql="UPDATE Member SET password=? WHERE id=? AND name=?";
		Session session =sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,mb.getPassword());
		query.setParameter(1,mb.getId());
		query.setParameter(2,mb.getName());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean deleteMember(Member mb) {		//删除学员信息
		String hql="DELETE Member WHERE id=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,mb.getId());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public Member findMemberById(String id) {		//搜索学员ID
		String hql="FROM Member WHERE id=?";
		Member mb=new Member();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, id);
		List<Member> list=query.list();
		for(int i=0;i<list.size();i++) {
			mb=list.get(i);
		}
		session.getTransaction().commit();
		session.close();
		return mb;
	}

	@Override
	public Member findMemberByName(String name) {		//搜索学员姓名
		String hql="FROM Member WHERE name=?";
		Member mb=new Member();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, name);
		List<Member> list=query.list();
		for(int i=0;i<list.size();i++) {
			mb=list.get(i);
		}
		session.getTransaction().commit();
		session.close();
		return mb;
	}
	
	public Member findMemberByPassword(String password) {		//搜索学员密码
		String hql="FROM Member WHERE password=?";
		Member mb=new Member();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, password);
		List<Member> list=query.list();
		for(int i=0;i<list.size();i++) {
			mb=list.get(i);
		}
		session.getTransaction().commit();
		session.close();
		return mb;
	}

	@Override
	public List<Member> findAllMember() {		//搜索所有学员信息
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(Member.class);
		crit.addOrder(Order.desc("depart"));
		crit.addOrder(Order.desc("duty"));
		crit.addOrder(Order.asc("name"));
		List<Member> list=crit.list();
		session.close();
		return list;
	}
	@Override
	public List<Member> findMemberByID(String id) {		//搜索学员个人信息
		String hql="FROM Member WHERE id=?";
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, id);
		List<Member> list=query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	public boolean updateMemberDuration(Member mb) {		//修改参加时长
		String hql="UPDATE Member SET join_time=join_time+? WHERE id=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,mb.getJoin_time());
		query.setParameter(1,mb.getId());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	@Override
	public boolean updateMemberNumber(Member mb) {		//修改参加次数
		String hql="UPDATE Member SET join_num=join_num+1 WHERE id=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,mb.getId());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	@Override
	public boolean updateMemberDurationZero(Member mb) {
		String hql="UPDATE Member SET join_time=0 WHERE id=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,mb.getId());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
	@Override
	public boolean updateMemberNumberZero(Member mb) {
		String hql="UPDATE Member SET join_num=0 WHERE id=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,mb.getId());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}
}
