package com.demo.service.factory;

import com.demo.service.ebo.MemberServiceImpl;

public class MemberFactory {
	public static MemberServiceImpl getMemberServiceImpl() {
		return new MemberServiceImpl();
	}
}
