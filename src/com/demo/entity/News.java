package com.demo.entity;

public class News {
	private String nno;
	private String inform;

	public News() {
	}
	public News(String nno, String inform) {
		super();
		this.nno = nno;
		this.inform = inform;
	}
	public String getNno() {
		return nno;
	}
	public void setNno(String nno) {
		this.nno = nno;
	}
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}


}
