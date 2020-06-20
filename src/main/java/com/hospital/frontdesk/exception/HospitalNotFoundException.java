package com.hospital.frontdesk.exception;

public class HospitalNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String hospitalName;

	public HospitalNotFoundException(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalName() {
		return hospitalName;
	}
	
}
