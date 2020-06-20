package com.hospital.frontdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hospital.frontdesk.dao.Appointment;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {	
	

}
