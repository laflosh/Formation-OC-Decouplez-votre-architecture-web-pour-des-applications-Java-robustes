package com.airbusiness.airbusiness_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airbusiness.airbusiness_mvc.entities.Client;
import com.airbusiness.airbusiness_mvc.repository.ClientRepository;

import jakarta.validation.Valid;

@Controller
public class ClientController {
	
	@Autowired
    private ClientRepository clientRepository;
	
 	@RequestMapping("/clients")
 	public String clientsForm( Model model) {
        model.addAttribute("clients", clientRepository.findAll());
 		return "clients";
 	}
    
    @GetMapping("/new-client")
    public String showNewClientForm(Client client) {
        return "add-client";
    }
    
    @PostMapping("/client/add")
    public String addClient(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-client";
        }
        
        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }
    
    @GetMapping("/client/edit/{id}")
    public String showUpdateClientForm(@PathVariable("id") long id, Model model) {
    	Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "update-client";
    }
    
    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "update-client";
        }
        
        clientRepository.save(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }
    
    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        clientRepository.delete(client);
        model.addAttribute("clients", clientRepository.findAll());
        return "clients";
    }
    
    @RequestMapping("/client/owe")
    public String clientOwe(Model model) {
    	
    	model.addAttribute("clients", clientRepository.findByOustandingBalanceGreaterThen(0.0));
    	
    	return "clients";
    }
    
}
