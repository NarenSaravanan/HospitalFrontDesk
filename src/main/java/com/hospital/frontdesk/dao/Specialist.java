package com.hospital.frontdesk.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("specialist")
public class Specialist {
	
	@Id
	public String id;
	
	private String name;
	private String type;
	private String availableDay;
	private String availableTime;
	private String isAvailable;
	
	private Hospital hospital;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAvailableDay() {
		return availableDay;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
