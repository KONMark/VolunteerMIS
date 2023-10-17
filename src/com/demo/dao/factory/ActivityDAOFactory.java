package com.demo.dao.factory;

import com.demo.dao.dao.ActivityDAOImpl;

public class ActivityDAOFactory {
	public static ActivityDAOImpl getActivityDAOImpl() {
		return new ActivityDAOImpl();
	}
}
