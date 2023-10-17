package com.demo.dao.dai;

import java.util.List;

import com.demo.entity.VolunteerInfo;

public interface VolunteerDAO {
	public boolean addVolunteer(VolunteerInfo vi);		//添加志愿信息
	public boolean deleteVolunteer(VolunteerInfo vi);	//删除志愿信息
	public List<VolunteerInfo> findAllVolunteer();		//搜索所有志愿信息
}
