package com.example.demo;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.secPolicies.PoliciesRepository;
import com.example.demo.account.Account;
import com.example.demo.account.AccountRepository;
import com.example.demo.branch.BankBranch;
import com.example.demo.trialUpload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class BankApplication implements CommandLineRunner {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PoliciesRepository policiesRepository;

	 
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BankBranch x = new BankBranch("no 7, saka jojo vi", 12345);
//		BankBranch y = new BankBranch("no 12, Access Road, Ogba, Ikeja, Lagos", 34561);
//		
//		Bank a = new Bank("John","Dele","amas",x,"asthe@gmai.com","hacker","saka jojo 7","savings",12345);
//		Bank b = new Bank("amas","arinze","ope",y,"nosa@gmai.com","student","saka bobo 7","current",7865);
//	
//		Account c = new Account(a, 100.00,0,0);
//		Account d = new Account(b, 50.00,0,0);
//
//
//		a = bankRepository.save(a);
//		b = bankRepository.save(b);
//		c = accountRepository.save(c);
//		d = accountRepository.save(d);
//		
//		c.deposit(320);
//		accountRepository.save(c);
//		
//		
//		d.withdraw(15.25);
//		accountRepository.save(d);
//		
		
		}

}

