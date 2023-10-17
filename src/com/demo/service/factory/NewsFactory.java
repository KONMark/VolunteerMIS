package com.demo.service.factory;

import com.demo.service.ebo.NewsServiceImpl;

public class NewsFactory {
	public static NewsServiceImpl getNewsServiceImpl() {
		return new NewsServiceImpl();
	}
}
