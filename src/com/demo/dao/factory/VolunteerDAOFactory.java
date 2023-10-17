package com.demo.dao.factory;

import com.demo.dao.dao.VolunteerDAOImpl;

public class VolunteerDAOFactory {
	public static VolunteerDAOImpl getVolunteerDAOImpl() {
		return new VolunteerDAOImpl();
	}
}
