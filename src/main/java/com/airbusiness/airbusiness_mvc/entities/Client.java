package com.airbusiness.airbusiness_mvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;
    
    private String address;
    private String telephone;
    private double outstandingBalance;

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
    
    public double getOutstandingBalance() {
    	return outstandingBalance;
    }
    
    public void setOutstandingBalance(double outstandingBalance) {
    	this.outstandingBalance = outstandingBalance;
    }
}
