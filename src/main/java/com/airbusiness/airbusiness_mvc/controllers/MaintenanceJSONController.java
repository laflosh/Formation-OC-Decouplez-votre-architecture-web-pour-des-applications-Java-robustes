package com.airbusiness.airbusiness_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbusiness.airbusiness_mvc.entities.MaintenanceIssue;
import com.airbusiness.airbusiness_mvc.repository.MaintenanceRepository;

@RestController
@RequestMapping(path = "v1/maintenance")
public class MaintenanceJSONController {

	@Autowired
	MaintenanceRepository maintenanceRepository;
	
	@GetMapping(path = "/", produces = "application/json")
	public Iterable<MaintenanceIssue> MaintenanceForm(Model model){
		
		return maintenanceRepository.findAll();
		
	}
	
}
