package com.example.relationships.services;

import org.springframework.stereotype.Service;

import com.example.relationships.models.License;
import com.example.relationships.repositories.LicenseRepository;

@Service
public class LicenseServices {
	private final LicenseRepository licenseRepository;

	public LicenseServices(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public String generateLicenseNumber() {
	    License license = licenseRepository.findTopByOrderByNumberDesc();
	    if(license == null)
	    	return String.format("%06d", 1);
	 
	    int largestNumber = Integer.parseInt(license.getNumber());
	    largestNumber++;
	    return String.format("%06d", largestNumber);
	}

}




