package com.example.demo;

public class PersonalityHelper {
	private String personality;
	private String secondPersonality;
	private double op;
	private double ag;
	private double ex;
	private double ne;
	private double co;
	
	public PersonalityHelper() {
		super();
	}

	public PersonalityHelper(String personality, double op, double ag, double ex, double ne, double co,String secondPersonality) {
		super();
		this.personality = personality;
		this.op = op;
		this.ne = ne;
		this.ex = ex;
		this.co = co;
		this.ag = ag;
		this.secondPersonality = this.calculateSecondPersonality();
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getSecondPersonality() {
		return secondPersonality;
	}

	public void setSecondPersonality(String secondPersonality) {
		this.secondPersonality = secondPersonality;
	}

	public double getOp() {
		return op;
	}

	public void setOp(double op) {
		this.op = op;
	}

	public double getNe() {
		return ne;
	}

	public void setNe(double ne) {
		this.ne = ne;
	}

	public double getEx() {
		return ex;
	}

	public void setEx(double ex) {
		this.ex = ex;
	}

	public double getCo() {
		return co;
	}

	public void setCo(double co) {
		this.co = co;
	}

	public double getAg() {
		return ag;
	}

	public void setAg(double ag) {
		this.ag = ag;
	}
	
	public String calculateSecondPersonality() {
		double max = this.ag;
		String[] personalities = {"agreeableness","conscientiousness","extroversion","neuroticism","openness"};
		String secondPersonality =  personalities[0];
		double[] values = {this.ag,this.co,this.ex,this.ne,this.op};
		for (int i = 1; i < values.length; i++) {
			System.out.println(max + " " + values[1]);
			if(max < values[i] && !personalities[i].equals(this.personality.toLowerCase())) {
				max = values[i];
				secondPersonality = personalities[i];
				System.out.println(max + " " + secondPersonality);
			}
		}
		
		return secondPersonality;
	}
}
