package com.demo.service.ebo;

import java.util.List;

import com.demo.dao.dai.ApplyDAO;
import com.demo.dao.factory.ApplyDAOFactory;
import com.demo.entity.ApplyList;
import com.demo.service.ebi.ApplyService;

public class ApplyServiceImpl implements ApplyService{
	private ApplyDAO apdao;

	public ApplyDAO getApdao() {
		return apdao;
	}

	public void setApdao(ApplyDAO apdao) {
		this.apdao = apdao;
	}

	@Override
	public boolean addApply(ApplyList al) {
		return apdao.addApply(al);
	}

	@Override
	public boolean updateApplyActionYes(ApplyList al) {
		return apdao.updateApplyActionYes(al);
	}

	@Override
	public boolean updateApplyActionNo(ApplyList al) {
		return apdao.updateApplyActionNo(al);
	}
	
	@Override
	public boolean updateApplyFeedback(ApplyList al) {
		return apdao.updateApplyFeedback(al);
	}
	
	@Override
	public boolean deleteApply(ApplyList al) {
		return apdao.deleteApply(al);
	}

	@Override
	public List<ApplyList> findAllApply() {
		List<ApplyList> list=apdao.findAllApply();
		return list;
	}

	@Override
	public List<ApplyList> findApplyByApno(String apno) {
		List<ApplyList> list=apdao.findApplyByApno(apno);
		return list;
	}
	
	public List<ApplyList> findApplyByAid(String aid) {
		List<ApplyList> list=apdao.findApplyByAid(aid);
		return list;
	}

	@Override
	public ApplyList findApplyByApnoAid(String apno, String aid) {
		return apdao.findApplyByApnoAid(apno, aid);
	}

	@Override
	public boolean updateApplyAsign(ApplyList al) {
		return apdao.updateApplyAsign(al);
	}

	@Override
	public boolean cancelApplyAsign(ApplyList al) {
		return apdao.cancelApplyAsign(al);
	}

}
