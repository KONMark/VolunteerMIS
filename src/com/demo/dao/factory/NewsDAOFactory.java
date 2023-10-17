package com.demo.dao.factory;

import com.demo.dao.dao.NewsDAOImpl;

public class NewsDAOFactory {
	public static NewsDAOImpl getNewsDAOImpl() {
		return new NewsDAOImpl();
	}
}
