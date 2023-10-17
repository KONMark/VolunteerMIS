package com.demo.entity;

public class Member {
	private String id;
	private String password;
	private String depart;
	private String duty;
	private String name;
	private String sex;
	private String tele;
	private String mclass;
	private String wechat;
	private String birth;
	private int join_num;
	private int join_time;
	private String dorm;
	public Member() {
	}
	public Member(String id, String password, String depart, String duty, String name, String sex, String tele,
			String mclass, String wechat, String birth, int join_num, int join_time, String dorm) {
		super();
		this.id = id;
		this.password = password;
		this.depart = depart;
		this.duty = duty;
		this.name = name;
		this.sex = sex;
		this.tele = tele;
		this.mclass = mclass;
		this.wechat = wechat;
		this.birth = birth;
		this.join_num = join_num;
		this.join_time = join_time;
		this.dorm = dorm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getmclass() {
		return mclass;
	}
	public void setmclass(String mclass) {
		this.mclass = mclass;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public int getJoin_num() {
		return join_num;
	}
	public void setJoin_num(int join_num) {
		this.join_num = join_num;
	}
	public int getJoin_time() {
		return join_time;
	}
	public void setJoin_time(int join_time) {
		this.join_time = join_time;
	}
	public String getDorm() {
		return dorm;
	}
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	
}
