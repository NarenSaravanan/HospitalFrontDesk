package com.hospital.frontdesk.dao;

public class Hospital {
	
	private String hospitalId;
	private String hospitalName;
	private int availableBeds;
	
	public int getAvailableBeds() {
		return availableBeds;
	}
	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
