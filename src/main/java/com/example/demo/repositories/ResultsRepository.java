package com.example.demo.repositories;



import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Results;

public interface ResultsRepository extends CrudRepository<Results, Long> {

	@Procedure
	void insert_or_update_results(@Param("qid")String qid,@Param("aid") int aid,@Param("stid") String stid);

	@Procedure
	void what_is_my_personality(@Param("stid")String stid);

	
}
