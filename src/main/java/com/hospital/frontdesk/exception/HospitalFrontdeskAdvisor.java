package com.hospital.frontdesk.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HospitalFrontdeskAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(SpecialistNotFoundException.class)
	public ResponseEntity<Object> handleSpecialistNotFoundException(SpecialistNotFoundException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		if (ex.getExceptionFor().equals("TYPE")) {
			body.put("message",
					"Apologies ! No " + ex.getSpecialist() + " Doctors available in " + ex.getHospitalName() + ".");
		} else {
			body.put("message", "Apologies ! Specialist " + ex.getSpecialist() + " is not available in "
					+ ex.getHospitalName() + ".");
		}

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<Object> handleHospitalNotFoundException(HospitalNotFoundException ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Apologies ! " + ex.getHospitalName() + " is not in our records.");

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SpecialistNotAvailableException.class)
	public ResponseEntity<Object> handleSpecialistNotAvailableException(SpecialistNotAvailableException ex,
			WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		if (ex.getAppointmentDay() == null) {
			body.put("message",
					"Apologies ! Specialist " + ex.getSpecialistName() + " will not be available for next few days.");
		} else {
			body.put("message",
					"Specialist " + ex.getSpecialistName() + " is not available on " + ex.getAppointmentDay() + ".");
		}

		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

}
