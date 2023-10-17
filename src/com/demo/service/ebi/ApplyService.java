package com.demo.service.ebi;

import java.util.List;

import com.demo.entity.ApplyList;

public interface ApplyService {
	public boolean addApply(ApplyList al);		//活动报名
	public boolean updateApplyActionYes(ApplyList al);		//确认报名
	public boolean updateApplyActionNo(ApplyList al);		//拒绝报名
	public boolean updateApplyFeedback(ApplyList al);		//反思反馈填写
	public boolean updateApplyAsign(ApplyList al);		//签到
	public boolean cancelApplyAsign(ApplyList al);	//取消签到
	public boolean deleteApply(ApplyList al);		//删除活动
	public ApplyList findApplyByApnoAid(String apno,String aid);		//精准查询
	public List<ApplyList> findAllApply();		//搜索所有活动
	public List<ApplyList> findApplyByApno(String apno);
	public List<ApplyList> findApplyByAid(String aid);
}
