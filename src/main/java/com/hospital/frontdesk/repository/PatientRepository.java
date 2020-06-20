package com.hospital.frontdesk.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.frontdesk.dao.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
	
	@Query("{'hospitalName': '?0', 'status' : '?1'}")
	public List<Patient> findByHospitalNameAndPatientStatus(String hospitalName, String patientStatus);	

}
