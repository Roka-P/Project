package com.kosa.myapp.athlete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosa.myapp.athlete.model.AthleteVO;
import com.kosa.myapp.athlete.service.IAthleteService;

@Controller
public class AthleteController {
	
	@Autowired
	IAthleteService athleteService;
	
	@RequestMapping(value={"/", "/ath/list"})
	public String getAthList(Model model) {
		List<AthleteVO> athList = athleteService.getAthList();
		model.addAttribute("athList", athList);
		return "ath/list";
	}
	
	@RequestMapping(value="/ath/{id}")
	public String getAthInfo(@PathVariable int id, Model model) {
		AthleteVO ath = athleteService.getAthInfo(id);
		model.addAttribute("ath", ath);
		return "ath/view";
	}
	
	

}
