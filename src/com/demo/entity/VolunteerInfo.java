package com.demo.entity;

import java.util.Date;

public class VolunteerInfo {
	private String vno;
	private String vname;
	private String vtime;
	private String vposition;
	private int vpeople;
	private int vduration;
	private String vcontext;
	public VolunteerInfo() {

	}
	public VolunteerInfo(String vno, String vname, String vtime, String vposition, int vpeople, int vduration,
			String vcontext) {
		super();
		this.vno = vno;
		this.vname = vname;
		this.vtime = vtime;
		this.vposition = vposition;
		this.vpeople = vpeople;
		this.vduration = vduration;
		this.vcontext = vcontext;
	}
	public String getVno() {
		return vno;
	}
	public void setVno(String vno) {
		this.vno = vno;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtime() {
		return vtime;
	}
	public void setVtime(String vtime) {
		this.vtime = vtime;
	}
	public String getVposition() {
		return vposition;
	}
	public void setVposition(String vposition) {
		this.vposition = vposition;
	}
	public int getVpeople() {
		return vpeople;
	}
	public void setVpeople(int vpeople) {
		this.vpeople = vpeople;
	}
	public int getVduration() {
		return vduration;
	}
	public void setVduration(int vduration) {
		this.vduration = vduration;
	}
	public String getVcontext() {
		return vcontext;
	}
	public void setVcontext(String vcontext) {
		this.vcontext = vcontext;
	}
	
}
