package com.demo.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.demo.entity.ActivityInfo;
import com.demo.entity.News;
import com.demo.service.ebi.ActivityService;
import com.demo.service.ebi.NewsService;
import com.opensymphony.xwork2.ActionContext;

public class ActivityAction{
	ActionContext context=ActionContext.getContext();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	private ActivityService acs;
	private NewsService ns;
	
	public NewsService getNs() {
		return ns;
	}
	public void setNs(NewsService ns) {
		this.ns = ns;
	}
	public ActivityService getacs() {
		return acs;
	}
	public void setacs(ActivityService acs) {
		this.acs = acs;
	}

	private ActivityInfo ai;
	public ActivityInfo getAi() {
		return ai;
	}
	public void setAi(ActivityInfo ai) {
		this.ai = ai;
	}
	
	public String send() {		//添加志愿活动页面跳转
			String aname=req.getParameter("aname");
			String aposition=req.getParameter("aposition");
			String aduration=req.getParameter("aduration");
			String atime=req.getParameter("atime");
			String acontext=req.getParameter("acontext");
			req.setAttribute("aname",aname);
			req.setAttribute("aposition",aposition);
			req.setAttribute("aduration",aduration);
			req.setAttribute("acontext",acontext);
			req.setAttribute("atime", atime);
			return "SUCCESS";
		}
	
	public String sendActivity() {		//发布志愿活动
		if(this.addActivity(req)&&this.addNews(req)) {		
			String message="发布成功！";
			req.setAttribute("message", message);
			return "SUCCESS";
		}else {
			String message="发布失败！";
			req.setAttribute("message", message);
			return "INPUT";
		}
	}
	
	public String selectallactivity() {		//查看所有在招募的志愿活动
		List<ActivityInfo> list=acs.findAllActivity();
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";		//"/list-activity-detail.jsp"和"/list-activity-manage.jsp"这个方法要两个
	}
	
	public String detail() {		//查看志愿活动的详细信息
		String ano=req.getParameter("ano");
		List<ActivityInfo> list=acs.findActivityByAno(ano);
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}
	
	public String end() {		//截止志愿活动
			this.updateAvtivityacstatus(req);
			List<ActivityInfo> list=acs.findAllActivity();
			HttpSession session=req.getSession();
			session.setAttribute("result", list);
			return "SUCCESS";
	}
	
	public String delete() {		//删除志愿活动
		this.deleteActivity(req);
		this.deleteNews(req);
		List<ActivityInfo> list=acs.findAllActivity();
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}

	public String selectcondition() {		//条件查询
		Map<String,String> condition=new HashMap<String,String>();
		Enumeration<String> paramNames=req.getParameterNames();
		while(paramNames.hasMoreElements()) {
			String key=paramNames.nextElement();		//取出参数的名字
			String value=req.getParameter(key);		//取出参数的值
			if(value!=null&&value.trim().length()!=0) {
				condition.put(key, value);
			}
		}
		List<ActivityInfo> list=acs.findByCondition(condition);
		if(list==null) {
			list=new ArrayList<ActivityInfo>();
		}
		HttpSession session=req.getSession();
		session.setAttribute("result", list);
		return "SUCCESS";
	}

//---------------------------------------------------------------------------------\\	
	
	private boolean addActivity(HttpServletRequest req) {		//添加活动信息
		ActivityInfo ai=new ActivityInfo();
		ai.setAno(req.getParameter("ano"));
		ai.setAname(req.getParameter("aname"));
		ai.setAtime(req.getParameter("atime"));
		ai.setAposition(req.getParameter("aposition"));
		String apeople=req.getParameter("apeople");
		int a_people=Integer.parseInt(apeople);
		ai.setApeople(a_people);
		String aduration=req.getParameter("aduration");
		int a_duration=Integer.parseInt(aduration);
		ai.setAduration(a_duration);
		ai.setAcaptation(req.getParameter("acaptation"));
		ai.setAstatus(req.getParameter("astatus"));
		ai.setAcontext(req.getParameter("acontext"));
		return acs.addActivity(ai);
	}
	private boolean addNews(HttpServletRequest req) {		//添加通知
		News news=new News();
		news.setNno(req.getParameter("nno"));
		news.setInform(req.getParameter("inform"));
		return ns.addNews(news);
	}
	private boolean deleteActivity(HttpServletRequest req) {		//删除活动
		ActivityInfo ai=new ActivityInfo();
		ai.setAno(req.getParameter("ano"));
		return acs.deleteActivity(ai);
	}
	private boolean updateAvtivityacstatus(HttpServletRequest req) {		//修改活动状态
		ActivityInfo ai=new ActivityInfo();
		ai.setAno(req.getParameter("ano"));
		return  acs.updateAvtivityAstatus(ai);
	}
	private List<ActivityInfo> findActivityByAno(HttpServletRequest req){		//根据活动编号搜索活动
		String ano=new String();
		ano=req.getParameter("ano");
		List<ActivityInfo> list=acs.findActivityByAno(ano);
		return list;
	}
	
	private boolean deleteNews(HttpServletRequest req) {		//删除通知
		News news=new News();
		news.setNno(req.getParameter("nno"));
		return ns.deleteNews(news);
	}
}
