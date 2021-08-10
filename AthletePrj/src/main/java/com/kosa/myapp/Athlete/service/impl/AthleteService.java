package com.kosa.myapp.athlete.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.athlete.dao.IAthleteRepository;
import com.kosa.myapp.athlete.model.AthleteVO;
import com.kosa.myapp.athlete.service.IAthleteService;

@Service
public class AthleteService implements IAthleteService {

	@Autowired
	IAthleteRepository athleteRepository;
	
	@Override
	public List<AthleteVO> getAthList() {
		return athleteRepository.getAthList();
	}

	@Override
	public AthleteVO getAthInfo(int athid) {
		return athleteRepository.getAthInfo(athid);
	}

}
