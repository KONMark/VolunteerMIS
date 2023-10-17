package com.demo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.demo.entity.ActivityInfo;
import com.demo.entity.ApplyList;
import com.demo.entity.News;
import com.demo.service.ebi.ActivityService;
import com.demo.service.ebi.ApplyService;
import com.demo.service.ebi.NewsService;
import com.opensymphony.xwork2.ActionContext;

public class NewsAction{
	ActionContext context=ActionContext.getContext();
	HttpServletRequest req = ServletActionContext.getRequest();
	HttpServletResponse resp=ServletActionContext.getResponse();
	private NewsService ns;
	private ApplyService aps;
	private ActivityService acs;
	private News news;
	public ApplyService getaps() {
		return aps;
	}
	public void setaps(ApplyService aps) {
		this.aps = aps;
	}
	public ActivityService getAcs() {
		return acs;
	}
	public void setAcs(ActivityService acs) {
		this.acs = acs;
	}
	public NewsService getNs() {
		return ns;
	}
	public void setNs(NewsService ns) {
		this.ns = ns;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	
	public String add() {		//添加新闻
		this.updateNewsByInform(req);
			String nno=req.getParameter("nno");
			News news=ns.findNewsByNno(nno);
			String inform=news.getInform();
			String message="编辑成功！";
			HttpSession session=req.getSession();
			session.setAttribute("inform", inform);
			session.setAttribute("nno", nno);
			req.setAttribute("message", message);
			return "SUCCESS";
	}
	
	public String select() {		//搜索通知
		String nno=req.getParameter("nno");
		String ano=req.getParameter("ano");
		String apno=req.getParameter("apno");
		String aid=req.getParameter("aid");
		News news=ns.findNewsByNno(nno);
		ApplyList al=aps.findApplyByApnoAid(apno, aid);
		String inform=news.getInform();			//通知内容
		String feedback=al.getFeedback();		//反思反馈
		List<ActivityInfo> list2=acs.findActivityByAno(ano);
		HttpSession session=req.getSession();
		session.setAttribute("inform", inform);
		session.setAttribute("result2",list2);
		session.setAttribute("feedback", feedback);
		session.setAttribute("apno", apno);
		session.setAttribute("aid", aid);
		return "SUCCESS";
	}
	
	public String update() {		//修改通知内容
		String nno=req.getParameter("nno");
		News news=ns.findNewsByNno(nno);
		String inform=news.getInform();
		HttpSession session=req.getSession();
		session.setAttribute("inform", inform);
		session.setAttribute("nno", nno);
		return "SUCCESS";
	}
	
	
	
//-----------------------------------------------------------------\\
	
	private boolean addNews(HttpServletRequest req) {		//添加通知
	News news=new News();
	news.setNno(req.getParameter("nno"));
	news.setInform(req.getParameter("inform"));
	return ns.addNews(news);
}
	
private boolean updateNewsByInform(HttpServletRequest req) {		//修改通知内容
	News news=new News();
	news.setNno(req.getParameter("nno"));
	news.setInform(req.getParameter("inform"));
	return ns.updateNewsByInform(news);
}

private News findNewsByNno(HttpServletRequest req) {		//搜索活动通知
	News news=new News();
	news.setNno(req.getParameter("nno"));
	return ns.findNewsByNno(news.getInform());
}

private ApplyList findApplyByApnoAid(HttpServletRequest req) {	//搜索报名信息
	ApplyList al=new ApplyList();
	al.setApno(req.getParameter("apno"));
	al.setAid(req.getParameter("aid"));
	return aps.findApplyByApnoAid(al.getApno(),al.getAid());
}
}
