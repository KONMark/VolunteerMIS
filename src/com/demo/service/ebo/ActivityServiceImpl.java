package com.demo.service.ebo;

import java.util.List;
import java.util.Map;

import com.demo.dao.dai.ActivityDAO;
import com.demo.dao.factory.ActivityDAOFactory;
import com.demo.entity.ActivityInfo;
import com.demo.service.ebi.ActivityService;

public class ActivityServiceImpl implements ActivityService{
	private ActivityDAO acdao;

	public ActivityDAO getAcdao() {
		return acdao;
	}

	public void setAcdao(ActivityDAO acdao) {
		this.acdao = acdao;
	}

	@Override
	public boolean addActivity(ActivityInfo ai) {
		return acdao.addActivity(ai);
	}

	@Override
	public boolean updateAvtivityAstatus(ActivityInfo ai) {
		return acdao.updateAvtivityAstatus(ai);
	}

	@Override
	public boolean deleteActivity(ActivityInfo ai) {
		return acdao.deleteActivity(ai);
	}

	@Override
	public List<ActivityInfo> findAllActivity() {
		List<ActivityInfo> list=acdao.findAllActivity();
		return list;
	}

	@Override
	public List<ActivityInfo> findActivityByAno(String ano) {
		List<ActivityInfo> list=acdao.findActivityByAno(ano);
		return list;
	}

	@Override
	public List<ActivityInfo> findByCondition(Map<String, String> condition) {
		List<ActivityInfo> list=acdao.findByCondition(condition);
		return list;
	}

	@Override
	public ActivityInfo findActivity(String ano) {
		return acdao.findActivity(ano);
	}
	

}
