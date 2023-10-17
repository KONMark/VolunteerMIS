package com.demo.service.ebo;

import java.util.List;

import com.demo.dao.dai.VolunteerDAO;
import com.demo.dao.factory.VolunteerDAOFactory;
import com.demo.entity.VolunteerInfo;
import com.demo.service.ebi.VolunteerService;

public class VolunteerServiceImpl implements VolunteerService{
	private VolunteerDAO vdao;
	public VolunteerDAO getVdao() {
		return vdao;
	}

	public void setVdao(VolunteerDAO vdao) {
		this.vdao = vdao;
	}

	@Override
	public boolean addVolunteer(VolunteerInfo vi) {
		return vdao.addVolunteer(vi);
	}

	@Override
	public boolean deleteVolunteer(VolunteerInfo vi) {
		return vdao.deleteVolunteer(vi);
	}

	@Override
	public List<VolunteerInfo> findAllVolunteer() {
		List<VolunteerInfo> list=vdao.findAllVolunteer();
		return list;
	}
	

}
