package com.demo.service.ebo;

import java.util.List;

import com.demo.dao.dai.MemberDAO;
import com.demo.entity.Member;
import com.demo.service.ebi.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDAO mdao;	
	public MemberDAO getMdao() {
		return mdao;
	}

	public void setMdao(MemberDAO mdao) {
		this.mdao = mdao;
	}

	@Override
	public boolean addMember(Member mb) {
		return mdao.addMember(mb);
	}

	@Override
	public boolean updateMemberPassword(Member mb) {
		return mdao.updateMemberPassword(mb);
	}

	@Override
	public boolean deleteMember(Member mb) {
		return mdao.deleteMember(mb);
	}

	@Override
	public Member findMemberById(String id) {
		return mdao.findMemberById(id);
	}

	@Override
	public Member findMemberByName(String name) {
		return mdao.findMemberByName(name);
	}

	@Override
	public Member findMemberByPassword(String password) {
		return mdao.findMemberByPassword(password);
	}
	
	@Override
	public List<Member> findAllMember() {
		List<Member> list=mdao.findAllMember();
		return list;
	}

	@Override
	public List<Member> findMemberByID(String id) {
		List<Member> list=mdao.findMemberByID(id);
		return list;
	}

	@Override
	public boolean updateMemberDuration(Member mb) {
		return mdao.updateMemberDuration(mb);
	}

	@Override
	public boolean updateMemberNumber(Member mb) {
		return mdao.updateMemberNumber(mb);
	}

	@Override
	public boolean updateMemberDurationZero(Member mb) {
		return mdao.updateMemberDurationZero(mb);
	}

	@Override
	public boolean updateMemberNumberZero(Member mb) {
		return mdao.updateMemberNumberZero(mb);
	}
}
