package com.talsoft.learningengine.domain;

import javax.persistence.Entity;

@Entity
public class Course 
{

	private long idCourse;
	private String name;
	private boolean online;
	private String description;
	private boolean validated;
	private boolean followed;


	public long getIdCourse()
	{
		return idCourse;
	}


	public void setIdCourse(long idCourse) 
	{
		this.idCourse = idCourse;
	}


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public boolean isOnline() 
	{
		return online;
	}


	public void setOnline(boolean online) 
	{
		this.online = online;
	}


	public String getDescription() 
	{
		return description;
	}


	public void setDescription(String description) 
	{
		this.description = description;
	}


	public boolean isValidated()
	{
		return validated;
	}


	public void setValidated(boolean validated) 
	{
		this.validated = validated;
	}


	public boolean isFollowed() 
	{
		return followed;
	}


	public void setFollowed(boolean followed) 
	{
		this.followed = followed;
	}
	
	
	
}
