package com.example.demo.secPolicies;

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
public class PoliciesControllers {

	@Autowired
	private PoliciesRepository policiesRepository;
	
	@GetMapping("/policies")
	public List<Policies> getAll(){
		return policiesRepository.findAll();	
	}
	
	@GetMapping("/policy/{id}")
	public Policies getOne(@PathVariable Long id) {
		return policiesRepository.getOne(id);
	}
	
	@DeleteMapping("/policy/{id}")
	public boolean deletePolicy(@PathVariable Long id) {
		policiesRepository.deleteById(id);
		return true;
	}
	
	@PutMapping("/policy")
	public Policies updatePolicies(@RequestBody Policies policies) {
		return policiesRepository.save(policies);
	}
	
	@PostMapping("/policy")
	public Policies createPolicies(@RequestBody Policies policies) {
		return policiesRepository.save(policies);
	}
	
}
