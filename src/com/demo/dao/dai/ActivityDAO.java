package com.demo.dao.dai;

import java.util.List;
import java.util.Map;

import com.demo.entity.ActivityInfo;

public interface ActivityDAO {
	public boolean addActivity(ActivityInfo ai);		//发布活动
	public boolean updateAvtivityAstatus(ActivityInfo ai);		//修改活动状态(确认活动)
	public boolean deleteActivity(ActivityInfo ai);		//删除活动
	public ActivityInfo findActivity(String ano);
	public List<ActivityInfo> findAllActivity();		//搜索所有活动
	public List<ActivityInfo> findActivityByAno(String ano);
	public List<ActivityInfo> findByCondition(Map<String,String> condition);		//模糊查询
	
}
