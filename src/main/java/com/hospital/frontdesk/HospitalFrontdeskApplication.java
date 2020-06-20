package com.hospital.frontdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class HospitalFrontdeskApplication {

	public static void main(String[] args) {
		
		 SpringApplication springApplication = new SpringApplication(HospitalFrontdeskApplication.class);		 
		 springApplication.run(args);
	}

}
