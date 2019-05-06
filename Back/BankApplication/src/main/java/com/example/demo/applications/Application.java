package com.example.demo.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Application {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private String uniResLoc;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUniResLoc() {
		return uniResLoc;
	}
	public void setUniResLoc(String uniResLoc) {
		this.uniResLoc = uniResLoc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", name=" + name + ", description=" + description + ", uniResLoc="
				+ uniResLoc + ", createDate=" + createDate + "]";
	}
	
	public Application(String name, String description, String uniResloc, Date createDate) {
		this.name = name;
		this.description = description;
		this.uniResLoc = uniResloc;
		this.createDate = createDate;
	}
	public Application() {

	}
	
	
}
