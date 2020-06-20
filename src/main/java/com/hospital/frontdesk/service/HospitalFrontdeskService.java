package com.hospital.frontdesk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospital.frontdesk.dao.Appointment;
import com.hospital.frontdesk.dao.Patient;
import com.hospital.frontdesk.dao.Specialist;
import com.hospital.frontdesk.exception.HospitalNotFoundException;
import com.hospital.frontdesk.exception.SpecialistNotAvailableException;
import com.hospital.frontdesk.exception.SpecialistNotFoundException;
import com.hospital.frontdesk.repository.AppointmentRepository;
import com.hospital.frontdesk.repository.PatientRepository;
import com.hospital.frontdesk.repository.SpecialistRepository;

@Service
public class HospitalFrontdeskService {
	
	@Autowired
	private SpecialistRepository specialistRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Cacheable("specialist")
	public List<Specialist> getAllSpecialistDetails() {
		
		if(specialistRepository.findAll().size() != 0) {
			return specialistRepository.findAll();
		} else {
			return new ArrayList<Specialist>();
		}
		
	}
	
	@Cacheable("specialist")
	public List<Specialist> getDetailsByHospitalNameAndType(String hospitalName, String specialistType) {
		
		if(specialistRepository.findByHospitalName(hospitalName).size() != 0) {
			if(specialistRepository.findByHospitalNameAndSpecialistType(hospitalName,specialistType).size() != 0) {
				return specialistRepository.findByHospitalNameAndSpecialistType(hospitalName,specialistType);		    
			} else {
				throw new SpecialistNotFoundException(hospitalName, specialistType, "TYPE");
			}	
		} else {
			throw new HospitalNotFoundException(hospitalName);
		}
		
	}
	
	
	public Appointment scheduleAppointment(String hospitalName,
			String specialistName,
			String patientName,
			String appointmentDay) {
		
		Specialist specialist = specialistRepository.findByHospitalNameAndSpecialistName(hospitalName,specialistName);
		
		if(specialistRepository.findByHospitalName(hospitalName).size() != 0) {
		
			if(specialist != null) {
				
				if(specialist.getIsAvailable().equals("Y")) {
			
					if(specialist.getAvailableDay().contains(appointmentDay))	{				
						saveAppointment(specialistName, patientName, appointmentDay, specialist.getAvailableTime());				
					} else {
						throw new SpecialistNotAvailableException(specialistName, appointmentDay);
					}
				
				} else {
					throw new SpecialistNotAvailableException(specialistName, null);
				}
				
			} else {
				throw new SpecialistNotFoundException(hospitalName, specialistName, "NAME");
			}	
			
		} else {
			throw new HospitalNotFoundException(hospitalName);
		}
		
		return (new Appointment(specialistName, patientName, appointmentDay, specialist.getAvailableTime()));	
		
	}
	
	public void saveAppointment(String specialistName,
			String patientName,
			String appointmentDay,
			String availableTime) {
		
		appointmentRepository.save(new Appointment(specialistName, patientName, appointmentDay, availableTime));
		
	}
	
	@Cacheable("hospital")
	public String getAvailableBeds(String hospitalName) {
		
		List<Specialist> hospitalList = specialistRepository.findByHospitalName(hospitalName);
		
		if(hospitalList.size() != 0) {
			
			int availableBeds = specialistRepository.findByHospitalName(hospitalName).get(0).getHospital().getAvailableBeds();
			
			List<Patient> patientList = patientRepository.findByHospitalNameAndPatientStatus(hospitalName, "Discharge");
			if(patientList.size() != 0) {
				availableBeds += patientList.size();
				updateAvailableBedsInHospital(hospitalList, availableBeds);
				updatePatientStatus(patientList, "Discharged");				
			}
			return ("Number of Beds Available for Admission in "+ hospitalName + " : "+availableBeds);			
			
		} else {
			throw new HospitalNotFoundException(hospitalName);
		}		
		
	}
	
	public void updateAvailableBedsInHospital(List<Specialist> hospitalList, int availableBeds) {
		
		for(Specialist specialist : hospitalList) {
			specialist.getHospital().setAvailableBeds(availableBeds);
			specialistRepository.save(specialist);
		}
	}
	
	public void updatePatientStatus(List<Patient> patientList, String statusToUpdate) {
		
		for(Patient patient : patientList) {
			patient.setStatus(statusToUpdate);
			patientRepository.save(patient);
		}
	}
	
	// Testing Caching Functionality
	/* private void simulateSlowService() {
	    try {
	    	long time = 5000L;
	    	Thread.sleep(time);
	    } catch (InterruptedException e) {
	    	throw new IllegalStateException(e);
	    }
	} */
}
