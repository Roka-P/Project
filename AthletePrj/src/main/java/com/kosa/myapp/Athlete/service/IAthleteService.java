package com.kosa.myapp.athlete.service;

import java.util.List;
import java.util.Map;

import com.kosa.myapp.athlete.model.AthleteVO;

public interface IAthleteService {

	List<AthleteVO> getAthList(); //모든 선수의 정보 조회
	AthleteVO getAthInfo(int athid); //지정한 선수의 모든 정보 조회

}
