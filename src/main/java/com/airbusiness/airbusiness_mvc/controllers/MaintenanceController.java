package com.airbusiness.airbusiness_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbusiness.airbusiness_mvc.entities.MaintenanceIssue;
import com.airbusiness.airbusiness_mvc.repository.MaintenanceRepository;

import jakarta.validation.Valid;

@RestController
public class MaintenanceController {
	
	@Autowired
    private  MaintenanceRepository maintenanceRepository;

 	@RequestMapping("/maintenance")
 	public String maintenanceForm( Model model) {
 		model.addAttribute("maintenance", maintenanceRepository.findAll());
 		return "maintenance";
 	}
	
    @GetMapping("/new-issue")
    public String showNewIssueForm(MaintenanceIssue maintenance) {
        return "add-maintenance";
    }
    
    @PostMapping("/maintenance/add")
    public String addMaintenance(@Valid MaintenanceIssue maintenance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-maintenance";
        }
        
        maintenanceRepository.save(maintenance);
        model.addAttribute("maintenance", maintenanceRepository.findAll());
        return "maintenance";
    }
    
    @GetMapping("/maintenance/edit/{id}")
    public String showUpdateMaintenanceForm(@PathVariable("id") long id, Model model) {
    	MaintenanceIssue maintenance = maintenanceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid maintenance Id:" + id));
        model.addAttribute("maintenance", maintenance);
        return "update-maintenance";
    }
    
    @PostMapping("/maintenance/update/{id}")
    public String updateMaintenance(@PathVariable("id") long id, @Valid MaintenanceIssue maintenance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            maintenance.setId(id);
            return "update-maintenance";
        }
        
        maintenanceRepository.save(maintenance);
        model.addAttribute("maintenance", maintenanceRepository.findAll());
        return "maintenance";
    }
    
    @GetMapping("/maintenance/delete/{id}")
    public String deleteMaintenance(@PathVariable("id") long id, Model model) {
    	MaintenanceIssue maintenance = maintenanceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid maintenance Id:" + id));
        maintenanceRepository.delete(maintenance);
        model.addAttribute("maintenance", maintenanceRepository.findAll());
        return "maintenance";
    }
    
}