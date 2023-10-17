package com.demo.service.factory;

import com.demo.service.ebo.ApplyServiceImpl;

public class ApplyFactory {
	public static ApplyServiceImpl getApplyServiceImpl() {
		return new ApplyServiceImpl();
	}
}
