package com.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.demo.entity.ActivityInfo;
import com.demo.entity.ApplyList;
import com.demo.entity.Member;
import com.demo.entity.News;
import com.demo.service.ebi.ActivityService;
import com.demo.service.ebi.ApplyService;
import com.demo.service.ebi.MemberService;
import com.demo.service.ebi.NewsService;
import com.opensymphony.xwork2.ActionContext;

public class ApplyAction{
	ActionContext context=ActionContext.getContext();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	private ApplyService aps;
	private MemberService ms;
	private ActivityService acs;
	private NewsService ns;	
	public NewsService getNs() {
		return ns;
	}

	public void setNs(NewsService ns) {
		this.ns = ns;
	}

	public ActivityService getAcs() {
		return acs;
	}

	public void setAcs(ActivityService acs) {
		this.acs = acs;
	}

	public MemberService getMs() {
		return ms;
	}

	public void setMs(MemberService ms) {
		this.ms = ms;
	}

	public ApplyService getaps() {
		return aps;
	}

	public void setaps(ApplyService aps) {
		this.aps = aps;
	}

	public String selectall() {		//搜索所有人的名单
		String apno=req.getParameter("apno");
		String aduration=req.getParameter("aduration");
		List<ApplyList> list=aps.findApplyByApno(apno);
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		session.setAttribute("apno", apno);
		session.setAttribute("aduration", aduration);
		return "SUCCESS";
	}
	
	public String toaddapply() {		//切换到报名列表
		String ano=req.getParameter("ano");
		String aname=req.getParameter("aname");
		HttpSession session=req.getSession();
		session.setAttribute("ano", ano);
		session.setAttribute("aname", aname);
		return "SUCCESS";
	}
	
	public String selectme() {		//搜索我的报名名单
		String aid=req.getParameter("aid");
		List<ApplyList> list=aps.findApplyByAid(aid);
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}
	
	public String apply() {		//报名
		if(this.addApply(req)) {
			String message="报名成功！";
			req.setAttribute("message", message);
			return "SUCCESS";
		}else {
			String message="报名失败！";
			req.setAttribute("message", message);
			return "INPUT";
		}
	}

	public String yes() {		//通过
		this.updateApplyActionYes(req);
			String apno=req.getParameter("apno");
			List<ApplyList> list=aps.findApplyByApno(apno);
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
	public String no() {		//未通过
		this.updateApplyActionNo(req);
			String apno=req.getParameter("apno");
			List<ApplyList> list=aps.findApplyByApno(apno);
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
	public String updateasign() {		//签到
		this.updateApplyasign(req);
			String aid=req.getParameter("aid");
			List<ApplyList> list=aps.findApplyByAid(aid);
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
	public String cancelasign() {		//取消签到
			this.cancelApplyasign(req);
				String aid=req.getParameter("aid");
				List<ApplyList> list=aps.findApplyByAid(aid);
				HttpSession session=req.getSession();
				session.setAttribute("result", list);
				return "SUCCESS";
	}
	
	public String feedback() {		//填写反思反馈
		this.updateApplyFeedback(req);
			this.jumptonews(req);
			String message="填写成功！请等待管理员审核...";
			req.setAttribute("message", message);
			return "SUCCESS";
	}
	
	public String exchange() {		//替换人员
		this.addApply(req);
			String message="替换成功！";
			req.setAttribute("message", message);
			return "SUCCESS";
	}
	
	public String delete() {		//删除
		this.deleteApply(req);
			String apno=req.getParameter("apno");
			List<ApplyList> list=aps.findApplyByApno(apno);
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
//---------------------------------------------------------------------\\
	private boolean addApply(HttpServletRequest req) {		//报名
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		al.setAname(req.getParameter("aname"));
		al.setName(req.getParameter("name"));
		al.setAction(req.getParameter("action"));
		al.setAsign(req.getParameter("asign"));
		al.setFeedback(req.getParameter("feedback"));
		return aps.addApply(al);
	}
	
	private boolean updateApplyActionYes(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.updateApplyActionYes(al);
	}
	
	private boolean updateApplyActionNo(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.updateApplyActionNo(al);
	}
	
	private boolean updateApplyFeedback(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setFeedback(req.getParameter("feedback"));
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.updateApplyFeedback(al);
	}
	
	private boolean updateApplyasign(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.updateApplyAsign(al);
	}
	
	private boolean cancelApplyasign(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.cancelApplyAsign(al);
	}
	
	private boolean deleteApply(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.deleteApply(al);
	}
	
	private List<Member> findMemberByID(HttpServletRequest req){		//搜索个人信息
		String id=new String();
		id=req.getParameter("id");
		List<Member> list=ms.findMemberByID(id);
		return list;
	}
	
	private ApplyList findApplyByApnoAid(HttpServletRequest req) {
		ApplyList al=new ApplyList();
		al.setApno(req.getParameter("apno"));
		al.setAid(req.getParameter("aid"));
		return aps.findApplyByApnoAid(al.getApno(),al.getAid());
	}
	
	public void jumptonews(HttpServletRequest req) {
		String nno=req.getParameter("nno");
		String ano=req.getParameter("ano");
		String apno=req.getParameter("apno");
		String aid=req.getParameter("aid");
		News news=ns.findNewsByNno(nno);
		ApplyList al=aps.findApplyByApnoAid(apno, aid);
		String inform=news.getInform();
		String feedback=al.getFeedback();
		List<ActivityInfo> list2=acs.findActivityByAno(ano);
		HttpSession session=req.getSession();
		session.setAttribute("inform", inform);
		session.setAttribute("result2",list2);
		session.setAttribute("feedback", feedback);
		session.setAttribute("aid", aid);
	}
	
}
