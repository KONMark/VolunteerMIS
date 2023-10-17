package com.demo.entity;

public class ApplyList {
	private String apno;
	private String aid;
	private String action;
	private String name;
	private String aname;
	private String asign;
	private String feedback;
	public ApplyList() {

	}
	public ApplyList(String apno, String aid, String action, String name, String aname, String asign, String feedback) {
		super();
		this.apno = apno;
		this.aid = aid;
		this.action = action;
		this.name = name;
		this.aname = aname;
		this.asign = asign;
		this.feedback = feedback;
	}
	public String getApno() {
		return apno;
	}
	public void setApno(String apno) {
		this.apno = apno;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAsign() {
		return asign;
	}
	public void setAsign(String asign) {
		this.asign = asign;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
}
