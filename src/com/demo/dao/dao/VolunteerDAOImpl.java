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
import com.demo.dao.dai.VolunteerDAO;
import com.demo.entity.ActivityInfo;
import com.demo.entity.VolunteerInfo;

public class VolunteerDAOImpl implements VolunteerDAO{
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
	public boolean addVolunteer(VolunteerInfo vi) {		//添加志愿活动
//		try {
//			conn=DBConnector.getConnection();
//			String sql="INSERT INTO VOLUNTEERINFO VALUES(?,?,?,?,?,?,?)";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, vi.getVno());
//			pstmt.setString(2, vi.getVname());
//			pstmt.setString(3, vi.getVtime());
//			pstmt.setString(4, vi.getVposition());
//			pstmt.setInt(5, vi.getVpeople());
//			pstmt.setInt(6, vi.getVduration());
//			pstmt.setString(7, vi.getVcontext());
//			pstmt.execute();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//				if(conn!=null)conn.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return true;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(vi);		//将对象放到了session的缓冲区中，没有开始执行操作
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public boolean deleteVolunteer(VolunteerInfo vi) {		//删除志愿活动
//		try {
//			conn=DBConnector.getConnection();
//			String sql="DELETE FROM VOLUNTEERINFO WHERE vno=?";
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1,vi.getVno());
//			pstmt.execute();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//				if(conn!=null)conn.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}	return true;
		String hql="DELETE FROM VolunteerInfo WHERE vno=?";
		Session session=sessionFactory.openSession();
		Query query=session.createQuery(hql);
		session.beginTransaction();
		query.setParameter(0,vi.getVno());
		query.executeUpdate();
		session.getTransaction().commit();		//获取事务执行
		session.close();
		return true;
	}

	@Override
	public List<VolunteerInfo> findAllVolunteer() {
//		List<VolunteerInfo> list=new ArrayList<VolunteerInfo>();
//		try {
//			conn=DBConnector.getConnection();
//			String sql="SELECT * FROM VOLUNTEERINFO ORDER BY vno";
//			stmt=conn.createStatement();
//			ResultSet rs=stmt.executeQuery(sql);
//			while(rs.next()) {
//				VolunteerInfo vi=new VolunteerInfo();
//				vi.setVno(rs.getString(1));
//				vi.setVname(rs.getString(2));
//				vi.setVtime(rs.getString(3));
//				vi.setVposition(rs.getString(4));
//				vi.setVpeople(rs.getInt(5));
//				vi.setVduration(rs.getInt(6));
//				vi.setVcontext(rs.getString(7));
//				list.add(vi);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(stmt!=null)stmt.close();
//				if(conn!=null)conn.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
		Session session=sessionFactory.openSession();
		Criteria crit=session.createCriteria(VolunteerInfo.class);
		crit.addOrder(Order.asc("vno"));
		List<VolunteerInfo> list=crit.list();
		session.close();
		return list;
	}

}
