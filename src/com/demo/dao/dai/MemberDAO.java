package com.demo.dao.dai;

import java.util.List;

import com.demo.entity.Member;

public interface MemberDAO {
	public boolean addMember(Member mb);		//添加学员信息
	public boolean updateMemberPassword(Member mb);		//修改密码
	public boolean updateMemberDuration(Member mb);		//修改参加时长
	public boolean updateMemberNumber(Member mb);		//修改参加次数
	public boolean updateMemberDurationZero(Member mb);		//参加时长清零
	public boolean updateMemberNumberZero(Member mb);		//参加次数清零
	public boolean deleteMember(Member mb);		//删除学员信息
	public Member findMemberById(String id);		//搜索学员学号
	public Member findMemberByName(String name);		//搜索学员姓名
	public Member findMemberByPassword(String password);		//搜索学员密码
	public List<Member> findAllMember();		//搜索所有学员信息
	public List<Member> findMemberByID(String id);		//搜索个人信息
}
