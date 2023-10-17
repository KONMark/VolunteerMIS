package com.demo.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import com.demo.common.DBConnector;
import com.demo.common.HbnUtil;
import com.demo.dao.dai.NewsDAO;
import com.demo.entity.ActivityInfo;
import com.demo.entity.Member;
import com.demo.entity.News;

public class NewsDAOImpl implements NewsDAO{
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
	public boolean addNews(News news) {		//添加新闻内容
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(news);		//将对象放到了session的缓冲区中，没有开始执行操作
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean updateNewsByInform(News news) {		//修改新闻内容
		String hql="UPDATE News SET inform=? WHERE nno=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,news.getInform());
		query.setParameter(1,news.getNno());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	public boolean deleteNews(News news) {
		String hql="DELETE FROM News WHERE nno=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,news.getNno());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	

	@Override
	public List<News> findNews() {
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(News.class);
		List<News> list=crit.list();
		session.close();
		return list;
	}

	@Override
	public News findNewsByNno(String nno) {
		String hql="FROM News WHERE nno=?";
		News news=new News();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, nno);
		List<News> list=query.list();
		for(int i=0;i<list.size();i++) {
			news=list.get(i);
		}
		session.getTransaction().commit();
		session.close();
		return news;
	}

}
