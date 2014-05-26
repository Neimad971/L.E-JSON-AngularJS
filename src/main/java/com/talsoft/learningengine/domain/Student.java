package com.talsoft.learningengine.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Student 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idStudent")
	private int idStudent;
	
	

	@Column(name = "firstname")
	private String firstname;
	
	

	@Column(name = "lastname")
	private String lastname;
	
	

	@Column(name = "login")
	private String login;
	
	

	@Column(name = "password")
	private String password;
}
