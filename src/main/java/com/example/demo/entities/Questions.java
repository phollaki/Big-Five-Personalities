package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Questions {
	@Id
	@Column
	private String qst_id;
	
	@Column(nullable = false)
	private String qst_title;
 
	
	public Questions() {
		
	}
	public Questions(String qst_id, String qst_title) {
		super();
		this.qst_id = qst_id;
		this.qst_title = qst_title;
	}
	
	public String getQst_id() {
		return qst_id;
	}
	public void setQst_id(String qst_id) {
		this.qst_id = qst_id;
	}
	public String getQst_title() {
		return qst_title;
	}
	public void setQst_title(String qst_title) {
		this.qst_title = qst_title;
	}
	
	
}
