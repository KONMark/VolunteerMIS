package com.demo.service.factory;

import com.demo.service.ebo.VolunteerServiceImpl;

public class VolunteerFactory {
	public static VolunteerServiceImpl getVolunteerServiceImpl() {
		return new VolunteerServiceImpl();
	}
}
