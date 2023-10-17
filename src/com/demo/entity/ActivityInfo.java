package com.demo.entity;


public class ActivityInfo {
	private String ano;
	private String aname;
	private String atime;
	private String aposition;
	private int apeople;
	private int aduration;
	private String acaptation;
	private String astatus;
	private String acontext;
	public ActivityInfo() {

	}
	public ActivityInfo(String ano, String aname, String atime, String aposition, int apeople, int aduration,
			String acaptation, String astatus, String acontext) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.atime = atime;
		this.aposition = aposition;
		this.apeople = apeople;
		this.aduration = aduration;
		this.acaptation = acaptation;
		this.astatus = astatus;
		this.acontext = acontext;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public String getAposition() {
		return aposition;
	}
	public void setAposition(String aposition) {
		this.aposition = aposition;
	}
	public int getApeople() {
		return apeople;
	}
	public void setApeople(int apeople) {
		this.apeople = apeople;
	}
	public int getAduration() {
		return aduration;
	}
	public void setAduration(int aduration) {
		this.aduration = aduration;
	}
	public String getAcaptation() {
		return acaptation;
	}
	public void setAcaptation(String acaptation) {
		this.acaptation = acaptation;
	}
	public String getAstatus() {
		return astatus;
	}
	public void setAstatus(String astatus) {
		this.astatus = astatus;
	}
	public String getAcontext() {
		return acontext;
	}
	public void setAcontext(String acontext) {
		this.acontext = acontext;
	}
	
}
