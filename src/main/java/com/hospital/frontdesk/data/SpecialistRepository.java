package com.hospital.frontdesk.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.hospital.frontdesk.dao.Specialist;

@Repository
public interface SpecialistRepository extends MongoRepository<Specialist, String> {
	
	  @Query("{'hospital.hospitalName': '?0', 'type' : '?1'}")
	  public List<Specialist> findByHospitalNameAndSpecialistType(String hospitalName, String specialistType);
	  
	  @Query("{'hospital.hospitalName': '?0', 'name' : '?1'}")
	  public Specialist findByHospitalNameAndSpecialistName(String hospitalName, String specialistName);
	  
	  @Query("{'hospital.hospitalName': '?0'}")
	  public List<Specialist> findByHospitalName(String hospitalName);

}
