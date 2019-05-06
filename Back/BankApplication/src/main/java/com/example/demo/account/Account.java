package com.example.demo.account;
import com.example.demo.*;
import com.example.demo.branch.BankBranch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {
	private enum accType {SAVINGS, CURRENT, FIXED_DEPOSIT}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Bank customer;
	private String accountType;
	private String accountNumber;
	@OneToOne
	private BankBranch BankBranch;
	
	public Account(com.example.demo.branch.BankBranch bankBranch) {
		
		BankBranch = bankBranch;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Bank getCustomer() {
		return customer;
	}
	public void setCustomer(Bank customer) {
		this.customer = customer;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Account(Bank customer, String accountType, String accountNumber) {

		this.customer = customer;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
	}
	public Account() {
	
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", customer=" + customer + ", accountType=" + accountType + ", accountNumber="
				+ accountNumber + ", BankBranch=" + BankBranch + "]";
	}
	public BankBranch getBankBranch() {
		return BankBranch;
	}
	public void setBankBranch(BankBranch bankBranch) {
		BankBranch = bankBranch;
	}

	
	
	
//	public void deposit(double money){
//		balance = money + balance; 
//		previousCreditTransaction= money;
//
//		}
//
//	public void withdraw(double money){
//
//		balance = balance - money;
//		previousDebitTransaction= money;
//		}
	
	
		
		

	
	
}
