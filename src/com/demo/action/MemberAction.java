package com.demo.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.demo.entity.ApplyList;
import com.demo.entity.Member;
import com.demo.service.ebi.ApplyService;
import com.demo.service.ebi.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction{
	private Member mb;
	ActionContext context=ActionContext.getContext();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	private MemberService ms;
	private ApplyService aps;
	
	public ApplyService getaps() {
		return aps;
	}

	public void setaps(ApplyService aps) {
		this.aps = aps;
	}

	public MemberService getMs() {
		return ms;
	}

	public void setMs(MemberService ms) {
		this.ms = ms;
	}

	public Member getMb() {
		return mb;
	}

	public void setMb(Member mb) {
		this.mb = mb;
	}
	
	public String memberlogin() {		//用户登录
		if(this.login()==true) {
			String id=mb.getId();
			String name=mb.getName();
			String depart=mb.getDepart();
			HttpSession session=req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("depart",depart);
			String checkusername=req.getParameter("checkusername");
			if(checkusername!=null&&checkusername.equals("checkusername")){		//记住用户名
				Cookie cookie1=new Cookie("uname",id);
				cookie1.setMaxAge(60*10);
				resp.addCookie(cookie1);
				return "SUCCESS";
			}else {
				return "SUCCESS";
			}
		}
		else {
			String judge="用户名或密码错误";
			req.setAttribute("judge", judge);
			return "INPUT";
		}	
	}
	
	public String adminlogin() {		//管理员登录
		if(this.login()==true) {
			String id=mb.getId();
			String name=mb.getName();
			String depart=mb.getDepart();
			HttpSession session=req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("depart",depart);
			String checkusername=req.getParameter("adminusername");
			if(checkusername!=null&&checkusername.equals("adminusername")){		//记住用户名
				Cookie cookie=new Cookie("adminusername",id);
				cookie.setMaxAge(60*10);
				resp.addCookie(cookie);
				return "SUCCESS";
			}else {
				return "SUCCESS";
			}
		}
		else {
			String judge="用户名或密码错误";
			req.setAttribute("judge", judge);
			return "INPUT";
		}	
	}
		
	public String register() {		//注册
		if(this.addMember(req)) {
			String message="注册成功";
			req.setAttribute("message",message);
			return "SUCCESS";
		}else {
			String message="注册失败";
			req.setAttribute("message", message);
			return "INPUT";
		}
	}
	
	public String updatepassword() {		//修改密码
		this.updatepassword(req);
		String message="修改成功!";
		req.setAttribute("message", message);
		return "SUCCESS";
	}
	
	public String selectallmember() {		//测试查询所有成员
		List<Member> list=ms.findAllMember();
		HttpSession session=req.getSession();
		session.setAttribute("result",list);
		return "SUCCESS";
	}
	
	public String selectallmember2() {		//管理员查询所有成员
		List<Member> list=ms.findAllMember();
		HttpSession session=req.getSession();
		session.setAttribute("result",list);
		return "SUCCESS";
	}
	
	public String selectmymember() {		//个人信息查询
		List<Member> list=ms.findMemberByID(req.getParameter("id"));
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}
	
	public String zero() {		//清零
		this.updateMemberDurationZero(req);
		this.updateMemberNumberZero(req);
			List<Member> list=ms.findAllMember();
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
	public String delete() {		//删除
		this.deleteMember(req);
			List<Member> list=ms.findAllMember();
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
	public String detail() {
		this.jumptomember(req);
		return "SUCCESS";
	}
	
	public String submit() {
		this.updateMemberDuration(req);
		this.updateMemberNumber(req);
			this.jumptomember(req);
			String message="活动完成!";
			req.setAttribute("message", message);
			return "SUCCESS";
	}
	
//---------------------------------------------------------------------\\
	
	private boolean login() {		//登录方法
		String id=req.getParameter("id");
		String password=req.getParameter("password");
		mb=ms.findMemberById(id);
		if(id.contentEquals(mb.getId())&& password.contentEquals(mb.getPassword())) {
			return true;
		}else {
			return false;
		}	
	}
	
	private boolean addMember(HttpServletRequest req) {		//注册
		Member mb=new Member();
		mb.setId(req.getParameter("id"));
		mb.setPassword(req.getParameter("password"));
		mb.setDepart(req.getParameter("depart"));
		mb.setDuty(req.getParameter("duty"));
		mb.setName(req.getParameter("name"));
		mb.setSex(req.getParameter("sex"));
		mb.setTele(req.getParameter("tele"));
		mb.setmclass(req.getParameter("mclass"));
		mb.setWechat(req.getParameter("wechat"));
		mb.setBirth(req.getParameter("birth"));
		String joinnum=req.getParameter("join_num");
		int join_num=Integer.parseInt(joinnum);
		mb.setJoin_num(join_num);
		String jointime=req.getParameter("join_time");
		int join_time=Integer.parseInt(jointime);
		mb.setJoin_time(join_time);
		mb.setDorm(req.getParameter("dorm"));
		return ms.addMember(mb);
	}
	
	private boolean updatepassword(HttpServletRequest req) {		//修改密码
		Member mb=new Member();
		mb.setId(req.getParameter("id"));
		mb.setPassword(req.getParameter("password"));
		mb.setName(req.getParameter("name"));
		return ms.updateMemberPassword(mb);
	}
	
	private boolean updateMemberDurationZero(HttpServletRequest req) {		//时长清零
		Member mb=new Member();
		mb.setId(req.getParameter("id"));
		return ms.updateMemberDurationZero(mb);
	}
	
	private boolean updateMemberNumberZero(HttpServletRequest req) {		//活动次数清零
		Member mb=new Member();
		String id=req.getParameter("id");
		mb.setId(id);
		return ms.updateMemberNumberZero(mb);
	}
	
	private boolean deleteMember(HttpServletRequest req) {		//删除成员信息
		Member mb=new Member();
		mb.setId(req.getParameter("id"));
		return ms.deleteMember(mb);
	}
	
	private boolean updateMemberDuration(HttpServletRequest req) {		//修改时长信息
		Member mb=new Member();
		String jointime=req.getParameter("join_time");
		int join_time=Integer.parseInt(jointime);
		mb.setJoin_time(join_time);
		mb.setId(req.getParameter("id"));
		return ms.updateMemberDuration(mb);
	}
	
	private boolean updateMemberNumber(HttpServletRequest req) {		//修改活动参加次数
		Member mb=new Member();
		String id=req.getParameter("id");
		mb.setId(id);
		return ms.updateMemberNumber(mb);
	}
	
	private void jumptomember(HttpServletRequest req) {		//页面跳转方法用
		String id=req.getParameter("id");
		String apno=req.getParameter("apno");
		String aid=req.getParameter("aid");
		String join_time=req.getParameter("aduration");
		List<Member> list=ms.findMemberByID(id);
		ApplyList al=aps.findApplyByApnoAid(apno, aid);
		String apsign=al.getAsign();
		String feedback=al.getFeedback();
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		session.setAttribute("apsign", apsign);
		session.setAttribute("feedback", feedback);
		session.setAttribute("join_time", join_time);
		session.setAttribute("apno", apno);
		session.setAttribute("aid", aid);
	}
}
