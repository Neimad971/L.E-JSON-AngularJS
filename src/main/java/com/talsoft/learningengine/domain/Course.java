package com.talsoft.learningengine.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCourse")
	private long idCourse;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "online")
	private boolean online;
	
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "validated")
	private boolean validated;
	
	
	/*@Column(name = "inscribed")
	private boolean inscribed;*/


	public long getIdCourse() {
		return idCourse;
	}


	public void setIdCourse(long idCourse) {
		this.idCourse = idCourse;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isOnline() {
		return online;
	}


	public void setOnline(boolean online) {
		this.online = online;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isValidated() {
		return validated;
	}


	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	
}
