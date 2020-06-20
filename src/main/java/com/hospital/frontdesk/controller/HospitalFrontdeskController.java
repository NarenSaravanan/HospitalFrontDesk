package com.hospital.frontdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.frontdesk.dao.Appointment;
import com.hospital.frontdesk.dao.Specialist;
import com.hospital.frontdesk.service.HospitalFrontdeskService;

@RestController
@PropertySource("classpath:specialist.properties")
public class HospitalFrontdeskController {
	
	@Autowired
	private HospitalFrontdeskService hospitalFrontDeskService;	
	
	@GetMapping("${specialist.getAllSpecialistDetailsURL}")
	public List<Specialist> getAllSpecialistDetails() {
		
		return hospitalFrontDeskService.getAllSpecialistDetails();
		
	}
	
	@GetMapping(value = "${specialist.getDetailsByHospitalNameAndTypeURL}")
	public List<Specialist> getDetailsByHospitalNameAndType(@PathVariable String hospitalName,
			@RequestParam(value = "type", required = true) String specialistType) {
		
		return hospitalFrontDeskService.getDetailsByHospitalNameAndType(hospitalName, specialistType);		
		
	}
	
	@GetMapping(value = "${appointment.scheduleAppointmentURL}")
	public Appointment scheduleAppointment(@PathVariable String hospitalName,
			@RequestParam(value = "specialistName", required = true) String specialistName,
			@RequestParam(value = "patientName", required = true) String patientName,
			@RequestParam(value = "appointmentDay", required = true) String appointmentDay) {
		
		return hospitalFrontDeskService.scheduleAppointment(hospitalName, specialistName,patientName,appointmentDay);		
		
	}
	
	@GetMapping(value = "${hospital.getAvailableBedsURL}")
	public String getAvailableBeds(@PathVariable String hospitalName) {
		
		return hospitalFrontDeskService.getAvailableBeds(hospitalName);		
		
	}

}
