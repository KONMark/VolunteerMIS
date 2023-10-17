package com.demo.dao.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.demo.entity.Member;

class MemberTest {

	private SessionFactory sessionFactory;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		String hql="FROM Member";
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery(hql);
		List<Member> list=query.list();
		list.forEach(System.out::println);
		session.getTransaction().commit();
		session.close();
	}

}
