package com.example.demo.branch;

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

public class BankBranchController {

	@Autowired
	private BankBranchRepository bankBranchRepository;
	
	@GetMapping("/bankBranches")
	private List<BankBranch> getBankBranch(){
		return bankBranchRepository.findAll();
	}
	
	@GetMapping("/bankBranch/{id}")
	private BankBranch getBankBranchId(@PathVariable Long id) {
		return bankBranchRepository.getOne(id);
	}
	
	@DeleteMapping("/bankBranch/{id}")
	private boolean deleteBankBranch(@PathVariable Long id) {
		bankBranchRepository.deleteById(id);
		return true;
	}
	
	@PostMapping("/bankBranch")
	private BankBranch createBankBranch(@RequestBody BankBranch bankBranch) {
		return bankBranchRepository.save(bankBranch);
	}
	
	@PutMapping("/bankBranch")
	private BankBranch updateBankBranch(@RequestBody BankBranch bankBranch) {
		return bankBranchRepository.save(bankBranch);
	}
}
