package com.airbusiness.airbusiness_mvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank(message = "First Name is mandatory")
    private String firstName;
    
    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    
	private String address;
	
	private String telephone;
	
	private String aircraftRating;
	
	private String arrivalAirport;
	
	private String departureAirport;
	
	private String licenseExpiration;
	
	private String licenseNumber;
    
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public String getFirstName() {
    	return firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }

    public String getLastName() {
    	return lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public String getAddress() {
    	return address;
    }
    public void setAddress(String address) {
    	this.address = address;
    }
    
    public String getTelephone() {
    	return telephone;
    }
    public void setTelephone(String telephone) {
    	this.telephone = telephone;
    }
    
	public String getAircraftRating() {
		return aircraftRating;
	}
	public void setAircraftRating(String aircraftRating) {
		this.aircraftRating = aircraftRating;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	public String getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getLicenseExpiration() {
		return licenseExpiration;
	}
	public void setLicenseExpiration(String licenseExpiration) {
		this.licenseExpiration = licenseExpiration;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
}