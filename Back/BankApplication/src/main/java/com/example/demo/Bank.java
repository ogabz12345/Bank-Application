package com.example.demo;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.demo.branch.BankBranch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	
	@OneToOne
	private BankBranch bankBranch;
	private String emailAddress;
	private String occupation;
	private String Address;
	private int customerId;
	public Bank(int customerId) {
		
		this.customerId = customerId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public BankBranch getBankBranch() {
		return bankBranch;
	}
	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public Bank(String firstName, String lastName, String middleName, BankBranch bankBranch, String emailAddress,
			String occupation, String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.bankBranch = bankBranch;
		this.emailAddress = emailAddress;
		this.occupation = occupation;
		this.Address = address;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", bankBranch=" + bankBranch + ", emailAddress=" + emailAddress + ", occupation=" + occupation
				+ ", Address=" + Address + ",customerId=" + customerId + "]";
	}
	public Bank() {
		
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
	
	

}
