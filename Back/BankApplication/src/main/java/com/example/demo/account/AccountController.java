package com.example.demo.account;

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

import com.example.demo.Bank;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/accounts")
	private List<Account> getAccounts(){
		return accountRepository.findAll();
	}
	
	@GetMapping("/account/{id}")
	private Account getAccount(@PathVariable Long id) {
		return accountRepository.getOne(id);
	}
	
	@DeleteMapping("/account/{id}")
	private boolean deleteAccount(@PathVariable Long id) {
		accountRepository.deleteById(id);
		return true;
	}
	
	@PostMapping("/account")
	private Account createAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
	@PutMapping("/account")
	private Account updateAccount(@RequestBody Account account) {
		return accountRepository.save(account);
	}
	
}
