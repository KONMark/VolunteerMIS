package com.demo.service.factory;

import com.demo.service.ebo.ActivityServiceImpl;

public class ActivityFactory {
	public static ActivityServiceImpl getActivityServiceImpl() {
		return new ActivityServiceImpl();
	}
}
