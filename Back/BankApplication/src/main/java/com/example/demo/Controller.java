package com.example.demo;

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
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class Controller {
	
	@Autowired
	private BankRepository bankRepository;
	
	@GetMapping("/customers")
	private List<Bank> getCustomers(){
		return bankRepository.findAll();
	}
	
	
	@GetMapping("/customer/{id}")
	private Bank getCustomer(@PathVariable Long id) {
		return bankRepository.getOne(id);
	}
	
	
	@DeleteMapping("/customer/{id}")
	private boolean deleteCustomer(@PathVariable Long id) {
		bankRepository.deleteById(id);
		return true;
	}
	
	
	@PostMapping("/customer")
	private Bank createCustomer(@RequestBody Bank bank) {
		return bankRepository.save(bank);
	}
	
	@PutMapping("/customer")
	private Bank updateCustomer(@RequestBody Bank bank) {
		return bankRepository.save(bank);
	}
	
	
}
