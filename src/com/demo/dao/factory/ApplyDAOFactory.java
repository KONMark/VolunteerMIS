package com.demo.dao.factory;

import com.demo.dao.dao.ApplyDAOImpl;

public class ApplyDAOFactory {
	public static ApplyDAOImpl getApplyDAOImpl() {
		return new ApplyDAOImpl();
	}
}
