package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Results{
	@Id
	@Column(nullable = false)
	private Long student_id;
	@Column(nullable = false)
	private int opn1;
	@Column(nullable = false)
	private int opn2;
	@Column(nullable = false)
	private int opn3;
	@Column(nullable = false)
	private int opn4;
	@Column(nullable = false)
	private int csn1;
	@Column(nullable = false)
	private int csn2;
	@Column(nullable = false)
	private int csn3;
	@Column(nullable = false)
	private int csn4;
	@Column(nullable = false)
	private int ext1;
	@Column(nullable = false)
	private int ext2;
	@Column(nullable = false)
	private int ext3;
	@Column(nullable = false)
	private int ext4;
	@Column(nullable = false)
	private int agg1;
	@Column(nullable = false)
	private int agg2;
	@Column(nullable = false)
	private int agg3;
	@Column(nullable = false)
	private int agg4;
	@Column(nullable = false)
	private int neu1;
	@Column(nullable = false)
	private int neu2;
	@Column(nullable = false)
	private int neu3;
	@Column(nullable = false)
	private int neu4;
	@Column(nullable = false)
	private int conscientiousness_score = 0;
	@Column(nullable = false)
	private int openness_score = 0;
	@Column(nullable = false)
	private int neuroticism_score = 0;
	@Column(nullable = false)
	private int extraversion_score = 0;
	@Column(nullable = false)
	private int aggreeableness_score = 0;
	

	public Results() {
		super();
	}


	public Results(Long student_id, int opn1, int opn2, int opn3, int opn4, int csn1, int csn2, int csn3, int csn4,
			int ext1, int ext2, int ext3, int ext4, int agg1, int agg2, int agg3, int agg4, int neu1, int neu2,
			int neu3, int neu4, int conscientiousness_score, int openness_score, int neuroticism_score,
			int extraversion_score, int aggreeableness_score) {
		super();
		this.student_id = student_id;
		this.opn1 = opn1;
		this.opn2 = opn2;
		this.opn3 = opn3;
		this.opn4 = opn4;
		this.csn1 = csn1;
		this.csn2 = csn2;
		this.csn3 = csn3;
		this.csn4 = csn4;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.agg1 = agg1;
		this.agg2 = agg2;
		this.agg3 = agg3;
		this.agg4 = agg4;
		this.neu1 = neu1;
		this.neu2 = neu2;
		this.neu3 = neu3;
		this.neu4 = neu4;
		this.conscientiousness_score = conscientiousness_score;
		this.openness_score = openness_score;
		this.neuroticism_score = neuroticism_score;
		this.extraversion_score = extraversion_score;
		this.aggreeableness_score = aggreeableness_score;
	}


	public Long getStudent_id() {
		return student_id;
	}


	public int getOpn1() {
		return opn1;
	}


	public void setOpn1(int opn1) {
		this.opn1 = opn1;
	}


	public int getOpn2() {
		return opn2;
	}


	public void setOpn2(int opn2) {
		this.opn2 = opn2;
	}


	public int getOpn3() {
		return opn3;
	}


	public void setOpn3(int opn3) {
		this.opn3 = opn3;
	}


	public int getOpn4() {
		return opn4;
	}


	public void setOpn4(int opn4) {
		this.opn4 = opn4;
	}


	public int getCsn1() {
		return csn1;
	}


	public void setCsn1(int csn1) {
		this.csn1 = csn1;
	}


	public int getCsn2() {
		return csn2;
	}


	public void setCsn2(int csn2) {
		this.csn2 = csn2;
	}


	public int getCsn3() {
		return csn3;
	}


	public void setCsn3(int csn3) {
		this.csn3 = csn3;
	}


	public int getCsn4() {
		return csn4;
	}


	public void setCsn4(int csn4) {
		this.csn4 = csn4;
	}


	public int getExt1() {
		return ext1;
	}


	public void setExt1(int ext1) {
		this.ext1 = ext1;
	}


	public int getExt2() {
		return ext2;
	}


	public void setExt2(int ext2) {
		this.ext2 = ext2;
	}


	public int getExt3() {
		return ext3;
	}


	public void setExt3(int ext3) {
		this.ext3 = ext3;
	}


	public int getExt4() {
		return ext4;
	}


	public void setExt4(int ext4) {
		this.ext4 = ext4;
	}


	public int getAgg1() {
		return agg1;
	}


	public void setAgg1(int agg1) {
		this.agg1 = agg1;
	}


	public int getAgg2() {
		return agg2;
	}


	public void setAgg2(int agg2) {
		this.agg2 = agg2;
	}


	public int getAgg3() {
		return agg3;
	}


	public void setAgg3(int agg3) {
		this.agg3 = agg3;
	}


	public int getAgg4() {
		return agg4;
	}


	public void setAgg4(int agg4) {
		this.agg4 = agg4;
	}


	public int getNeu1() {
		return neu1;
	}


	public void setNeu1(int neu1) {
		this.neu1 = neu1;
	}


	public int getNeu2() {
		return neu2;
	}


	public void setNeu2(int neu2) {
		this.neu2 = neu2;
	}


	public int getNeu3() {
		return neu3;
	}


	public void setNeu3(int neu3) {
		this.neu3 = neu3;
	}


	public int getNeu4() {
		return neu4;
	}


	public void setNeu4(int neu4) {
		this.neu4 = neu4;
	}


	public int getConscientiousness_score() {
		return conscientiousness_score;
	}


	public void setConscientiousness_score(int conscientiousness_score) {
		this.conscientiousness_score = conscientiousness_score;
	}


	public int getOpenness_score() {
		return openness_score;
	}


	public void setOpenness_score(int openness_score) {
		this.openness_score = openness_score;
	}


	public int getNeuroticism_score() {
		return neuroticism_score;
	}


	public void setNeuroticism_score(int neuroticism_score) {
		this.neuroticism_score = neuroticism_score;
	}


	public int getExtraversion_score() {
		return extraversion_score;
	}


	public void setExtraversion_score(int extraversion_score) {
		this.extraversion_score = extraversion_score;
	}


	public int getAggreeableness_score() {
		return aggreeableness_score;
	}


	public void setAggreeableness_score(int aggreeableness_score) {
		this.aggreeableness_score = aggreeableness_score;
	}


	public void setStudent_id(Long stuid) {
		this.student_id = stuid;
	}


	@Override
	public String toString() {
		return "Results [student_id=" + student_id + ", opn1=" + opn1 + ", opn2=" + opn2 + ", opn3=" + opn3 + ", opn4="
				+ opn4 + ", csn1=" + csn1 + ", csn2=" + csn2 + ", csn3=" + csn3 + ", csn4=" + csn4 + ", ext1=" + ext1
				+ ", ext2=" + ext2 + ", ext3=" + ext3 + ", ext4=" + ext4 + ", agg1=" + agg1 + ", agg2=" + agg2
				+ ", agg3=" + agg3 + ", agg4=" + agg4 + ", neu1=" + neu1 + ", neu2=" + neu2 + ", neu3=" + neu3
				+ ", neu4=" + neu4 + ", conscientiousness_score=" + conscientiousness_score + ", openness_score="
				+ openness_score + ", neuroticism_score=" + neuroticism_score + ", extraversion_score="
				+ extraversion_score + ", aggreeableness_score=" + aggreeableness_score + "]";
	}
	
	public int[] getAllAnswers() {
		int[] answers = {this.getOpn1(),
		                        this.getOpn2(),
		                        this.getOpn3(),
		                        this.getOpn4(),
		                        this.getAgg1(),
		                        this.getAgg2(),
		                        this.getAgg3(),
		                        this.getAgg4(),
		                        this.getNeu1(),
		                        this.getNeu2(),
		                        this.getNeu3(),
		                        this.getNeu4(),
		                        this.getExt1(),
		                        this.getExt2(),
		                        this.getExt3(),
		                        this.getExt4(),
		                        this.getCsn1(),
		                        this.getCsn2(),
		                        this.getCsn3(),
		                        this.getCsn4()};
		return answers;
	}
	public int[] getAllAnswersInOrder() {
		int[] answers = {
				this.getOpn1(),this.getCsn1(),this.getExt1(),this.getAgg1(), this.getNeu1(),               
				this.getOpn2(),this.getCsn2(),this.getExt2(),this.getAgg2(),this.getNeu2(),
				this.getOpn3(),this.getCsn3(),this.getExt3(),this.getAgg3(),this.getNeu3(),
		        this.getOpn4(),this.getCsn4(),this.getExt4(),this.getAgg4(),this.getNeu4()};
		return answers;
	}
}
