package com.talsoft.learningengine.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class AssessmentResult 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAssessmentResult")
	private int idAssessmentResult;
	

	@Column(name = "score")
	private int score;
	

	@Column(name = "status")
	private boolean status;
	
}
