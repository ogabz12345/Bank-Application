package com.example.demo.applications;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins ="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ApplicationController {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@GetMapping("/applications")
	public List<Application> getAll(){
		return applicationRepository.findAll();	
	}
	
	@GetMapping("/application/{id}")
	public Application getOne(@PathVariable Long id) {
		return applicationRepository.getOne(id);
	}
	
	@DeleteMapping("/application/{id}")
	public boolean deleteTrade(@PathVariable Long id) {
		applicationRepository.deleteById(id);
		return true;
	}
	
	@PutMapping("/application")
	public Application updateTrade(@RequestBody Application application) {
		Date n = new Date();
		application.setCreateDate(n);
		return applicationRepository.save(application);
	}
	
	@PostMapping("/application")
	public Application createTrade(@RequestBody Application application) {
		Date n = new Date();
		application.setCreateDate(n);
		return applicationRepository.save(application);
	}

}
