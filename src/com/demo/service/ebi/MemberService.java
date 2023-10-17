package com.demo.service.ebi;

import java.util.List;

import com.demo.entity.Member;

public interface MemberService {
	public boolean addMember(Member mb);
	public boolean updateMemberPassword(Member mb);
	public boolean updateMemberDuration(Member mb);		//修改参加时长
	public boolean updateMemberNumber(Member mb);		//修改参加次数
	public boolean updateMemberDurationZero(Member mb);		//参加时长清零
	public boolean updateMemberNumberZero(Member mb);		//参加次数清零
	public boolean deleteMember(Member mb);
	public Member findMemberById(String id);
	public Member findMemberByName(String name);
	public Member findMemberByPassword(String password);
	public List<Member> findAllMember();
	public List<Member> findMemberByID(String id);		//搜索个人信息
}
