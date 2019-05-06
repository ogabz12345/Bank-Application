package com.example.demo.branch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BankBranch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String branchLocation;
	private int branchNumber;
	private int branchCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBranchLocation() {
		return branchLocation;
	}
	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}
	public int getBranchNumber() {
		return branchNumber;
	}
	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}
	public BankBranch(String branchLocation, int branchNumber) {
		
		this.branchLocation = branchLocation;
		this.branchNumber = branchNumber;
	}
	public BankBranch() {
		
	}
	@Override
	public String toString() {
		return "BankBranch [id=" + id + ", branchLocation=" + branchLocation + ", branchNumber=" + branchNumber
				+ ", branchCode=" + branchCode + "]";
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public BankBranch(int branchCode) {
	
		this.branchCode = branchCode;
	}
	
	
	

}
