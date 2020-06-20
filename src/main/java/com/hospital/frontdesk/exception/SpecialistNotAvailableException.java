package com.hospital.frontdesk.exception;

public class SpecialistNotAvailableException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String specialistName;
	private String appointmentDay;
	
	public String getSpecialistName() {
		return specialistName;
	}

	public String getAppointmentDay() {
		return appointmentDay;
	}

	public SpecialistNotAvailableException(String specialistName, String appointmentDay) {
		this.specialistName = specialistName;
		this.appointmentDay = appointmentDay;
	}		
	
}
