package com.hospital.frontdesk.exception;

public class SpecialistNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String hospitalName;
	private String specialist;
	private String exceptionFor;

	public SpecialistNotFoundException(String hospitalName, String specialist, String exceptionFor) {
		this.hospitalName = hospitalName;
		this.specialist = specialist;
		this.exceptionFor = exceptionFor;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public String getSpecialist() {
		return specialist;
	}
	
	public String getExceptionFor() {
		return exceptionFor;
	}

}
