package com.hospital.frontdesk.restclient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hospital.frontdesk.dao.Specialist;

public class HospitalFrontdeskRestClient {
	
	 private static final String RESOURCE_PATH = "/getDetails/{hospitalName}";
	 private String REQUEST_URL;
	 
	 private RestTemplate restTemplate;
	 
	 public HospitalFrontdeskRestClient(RestTemplateBuilder restTemplateBuilder) {
		 restTemplate = restTemplateBuilder.build();
	 }
	 
	 public List<Specialist> getSpecialistDetails(String environment, int port, 
			 String hospitalName, String specialistType) {
		 	this.REQUEST_URL = environment + ":" + port + RESOURCE_PATH + "?type=" + specialistType;
		 	  ResponseEntity<Specialist[]> entity = restTemplate.getForEntity(this.REQUEST_URL,
		        		Specialist[].class, hospitalName);
		 	System.out.println("Entity Body : "+entity.getBody());
	        return entity.getBody() != null? Arrays.asList(entity.getBody()) :                          
                Collections.emptyList();
	    }
	 
}
