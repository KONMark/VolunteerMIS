package com.demo.dao.factory;

import com.demo.dao.dao.MemberDAOImpl;

public class MemberDAOFactory {
	public static MemberDAOImpl getMemberDAOImpl() {
		return new MemberDAOImpl();
	}
}
