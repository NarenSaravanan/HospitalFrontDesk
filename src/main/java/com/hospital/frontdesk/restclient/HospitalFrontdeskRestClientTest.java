package com.hospital.frontdesk.restclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import com.hospital.frontdesk.dao.Specialist;

@RunWith(SpringRunner.class)
@RestClientTest(HospitalFrontdeskRestClient.class)
public class HospitalFrontdeskRestClientTest {	
	
	@Autowired
    private HospitalFrontdeskRestClient restClient; 
 
    @Test
    public List<Specialist> callGetSpecialistDetails()
      throws Exception {
 
        List<Specialist> specialist = restClient.getSpecialistDetails("localhost", 8089, 
        		"Greenways Hospital", "Cardiologist"); 
       
        System.out.println("From Client : "+specialist);
        
        return specialist;
    }
    
    @GetMapping(value = "${rest.testRestClientURL}")
	public List<Specialist> testRestClient() throws Exception {
		
		return (callGetSpecialistDetails());		
		
	}
	 
}
