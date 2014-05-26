package com.talsoft.learningengine.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;


public class Assessment 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAssessment")
	private int idAssessment;
	
	
	//@Getter @Setter
	@Column(name = "title")
	private String title;
	
	
	//@Getter @Setter
	@Column(name = "dateOfAssessment")
	private DateTime dateOfAssessment;
	
	
	//@Getter @Setter
	@Column(name = "duration")
	private int daration;
	
	
	//@Getter @Setter
	@Column(name = "assessmentResult")
	@OneToOne
	private AssessmentResult assessmentResult;


	public int getIdAssessment() {
		return idAssessment;
	}


	public void setIdAssessment(int idAssessment) {
		this.idAssessment = idAssessment;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public DateTime getDateOfAssessment() {
		return dateOfAssessment;
	}


	public void setDateOfAssessment(DateTime dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}


	public int getDaration() {
		return daration;
	}


	public void setDaration(int daration) {
		this.daration = daration;
	}


	public AssessmentResult getAssessmentResult() {
		return assessmentResult;
	}


	public void setAssessmentResult(AssessmentResult assessmentResult) {
		this.assessmentResult = assessmentResult;
	}
	
	
	
}
