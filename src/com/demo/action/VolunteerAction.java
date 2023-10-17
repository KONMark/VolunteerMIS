package com.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.demo.entity.VolunteerInfo;
import com.demo.service.ebi.VolunteerService;
import com.opensymphony.xwork2.ActionContext;

public class VolunteerAction{
	ActionContext context=ActionContext.getContext();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	private VolunteerService vs;
	private VolunteerInfo vi;
	
	public VolunteerService getVs() {
		return vs;
	}
	public void setVs(VolunteerService vs) {
		this.vs = vs;
	}
	public VolunteerInfo getVi() {
		return vi;
	}
	public void setVi(VolunteerInfo vi) {
		this.vi = vi;
	}
	
	public String addVounteerInfo() {		//添加志愿信息
		if(this.addVolunteer(req)) {
			String message="添加成功！";
			req.setAttribute("message", message);
			return "SUCCESS";
		}else {
			String message="添加失败！";
			req.setAttribute("message", message);
			return "INPUT";
		}
	}
	public String selectallvolunteer() {		//搜索所有志愿信息(list-volunteerinfo-manage.jsp)
		List<VolunteerInfo> list=vs.findAllVolunteer();
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}
	
	public String selectallvolunteer2() {		//搜索所有志愿信息(list-volunteerinfo.jsp)
		List<VolunteerInfo> list=vs.findAllVolunteer();
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}
	
	public String deletevolunteer() {		//删除志愿信息
		this.deleteVolunteer(req);
		List<VolunteerInfo> list=vs.findAllVolunteer();
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}
	
//--------------------------------------------------------------------\\
	private boolean addVolunteer(HttpServletRequest req) {		//添加志愿信息
		VolunteerInfo vi=new VolunteerInfo();
		vi.setVno(req.getParameter("vno"));
		vi.setVname(req.getParameter("vname"));
		vi.setVtime(req.getParameter("vtime"));
		vi.setVposition(req.getParameter("vposition"));
		String vpeople=req.getParameter("vpeople");
		int v_people=Integer.parseInt(vpeople);
		vi.setVpeople(v_people);
		String vduration=req.getParameter("vduration");
		int v_duration=Integer.parseInt(vduration);
		vi.setVduration(v_duration);
		vi.setVcontext(req.getParameter("vcontext"));
		return vs.addVolunteer(vi);
	}
	private boolean deleteVolunteer(HttpServletRequest req) {		//删除志愿信息
		VolunteerInfo vi=new VolunteerInfo();
		vi.setVno(req.getParameter("vno"));
		return vs.deleteVolunteer(vi);
	}
}
