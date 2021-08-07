package com.kosa.myapp.Athlete.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kosa.myapp.Athlete.model.AthleteVO;

public interface IAthleteRepository {
	
	List<AthleteVO> getAthList();
	AthleteVO getAthInfo(int athid);
	void updateAth(AthleteVO athlete);
	void insertAth(AthleteVO athlete);
	void deleteAth(@Param("athid") int athid, @Param("birthDate") String birthdate);
	
	List<Map<String, Object>> getAllSportsId();
	
	String getPassword(int adminid);
	
}
