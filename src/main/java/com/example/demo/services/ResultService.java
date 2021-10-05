package com.example.demo.services;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Results;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.repositories.ResultsRepository;

@Service
public class ResultService {
	@Autowired
	private ResultsRepository resultRepository;
	
	public Optional<Results> getStudentResultData(Long id) {
		return resultRepository.findById(id);
	}
	
	public int[] saveOrUpdate(Map<String, String> list){
		long stuid = Long.parseLong(list.get("0"));
		Results result = new Results();
		result.setStudent_id(stuid);
		
		for (int i = 0; i < list.size(); i++) {
			  result.setOpn1(Integer.parseInt(list.get("opn1")));
			  result.setOpn2(Integer.parseInt(list.get("opn2")));
			  result.setOpn3(Integer.parseInt(list.get("opn3")));
			  result.setOpn4(Integer.parseInt(list.get("opn4")));
			  result.setCsn1(Integer.parseInt(list.get("csn1")));
			  result.setCsn2(Integer.parseInt(list.get("csn2")));
			  result.setCsn3(Integer.parseInt(list.get("csn3")));
			  result.setCsn4(Integer.parseInt(list.get("csn4")));
			  result.setExt1(Integer.parseInt(list.get("ext1")));
			  result.setExt2(Integer.parseInt(list.get("ext2")));
			  result.setExt3(Integer.parseInt(list.get("ext3")));
			  result.setExt4(Integer.parseInt(list.get("ext4")));
			  result.setAgg1(Integer.parseInt(list.get("agg1")));
			  result.setAgg2(Integer.parseInt(list.get("agg2")));
			  result.setAgg3(Integer.parseInt(list.get("agg3")));
			  result.setAgg4(Integer.parseInt(list.get("agg4")));
			  result.setNeu1(Integer.parseInt(list.get("neu1")));
			  result.setNeu2(Integer.parseInt(list.get("neu2")));
			  result.setNeu3(Integer.parseInt(list.get("neu3")));
			  result.setNeu4(Integer.parseInt(list.get("neu4")));
		}
		resultRepository.save(result);
		
		return result.getAllAnswers();
	}

	public void insertPersonality(String stuid) {
		resultRepository.what_is_my_personality(stuid);
	}
	public Double[] getStudentResult(String stu_id) {
		Results student = resultRepository.findById(Long.parseLong(stu_id)).orElseThrow(()->new StudentNotFoundException("Student id is not found"));
		Double [] results = new Double [5];
		double agreeableness = student.getAggreeableness_score();
		double openness = student.getOpenness_score();
		double neuroticism = student.getNeuroticism_score();
		double extroversion = student.getExtraversion_score();
		double conscientiousness = student.getConscientiousness_score();
		results[0] = openness;
		results[1] = agreeableness;
		results[2] = extroversion;
		results[3] = neuroticism;
		results[4] = conscientiousness;
		return results;
	}
	
}
