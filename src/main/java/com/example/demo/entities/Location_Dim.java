package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location_Dim {
	@Id
	@Column(name="loc_code")
	private Long loc_code;
	
	@Column(name="loc_name")
	private String loc_name;
	
	@Column(name="density")
	private int density;
	
	@Column(name="avarage_temp")
	private double average_temp;
	
	@Column(name="invidualism_score")
	private int invidualism_score;
	
	public Location_Dim() {
		super();
	}
	public Location_Dim(String loc_name, int density, double average_temp, int invidualism_score, Long loc_code) {
		super();
		this.loc_name = loc_name;
		this.density = density;
		this.average_temp = average_temp;
		this.invidualism_score = invidualism_score;
		this.loc_code = loc_code;
	}




	public String getLoc_name() {
		return loc_name;
	}
	public void setLoc_name(String loc_name) {
		this.loc_name = loc_name;
	}
	public int getDensity() {
		return density;
	}
	public void setDensity(int density) {
		this.density = density;
	}
	public double getAverage_temp() {
		return average_temp;
	}
	public void setAverage_temp(double average_temp) {
		this.average_temp = average_temp;
	}
	public int getInvidualism_score() {
		return invidualism_score;
	}
	public void setInvidualism_score(int invidualism_score) {
		this.invidualism_score = invidualism_score;
	}
	public Long getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(Long loc_code) {
		this.loc_code = loc_code;
	}
	@Override
	public String toString() {
		return "Location_Dim [loc_name=" + loc_name + ", density=" + density + ", average_temp=" + average_temp
				+ ", invidualism_score=" + invidualism_score + ", loc_code=" + loc_code + "]";
	}
	
	
}
