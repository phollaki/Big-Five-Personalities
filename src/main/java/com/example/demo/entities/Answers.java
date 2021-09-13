package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="answers")
public class Answers {
	@Id
	@Column(nullable = false)
	private int answ_id;
	
	@Column(nullable = false)
	private String answ_title;
	
	public Answers() {
		super();
	}

	public Answers(int answ_id, String answ_title) {
		super();
		this.answ_id = answ_id;
		this.answ_title = answ_title;
	}

	public int getAnsw_id() {
		return answ_id;
	}

	public void setAnsw_id(int answ_id) {
		this.answ_id = answ_id;
	}

	public String getAnsw_title() {
		return answ_title;
	}

	public void setAnsw_title(String answ_title) {
		this.answ_title = answ_title;
	}
	
	
}
