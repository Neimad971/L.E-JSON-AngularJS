package com.talsoft.learningengine.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;


public class AssessmentSession 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAssessmentSession")
	private int idAssessmentSession;
	
	

	@Column(name = "title")
	private String title;
	
	

	@Column(name = "beginDate")
	private DateTime beginDate;
	
	

	@Column(name = "endDate")
	private DateTime endDate;
	
	
	@Column(name = "assessments")
	@OneToMany
	private List<Assessment> assessments;
}
