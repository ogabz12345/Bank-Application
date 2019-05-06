package com.example.demo.mail;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
public class Feedback {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	private String feedback;
	
	@JsonFormat(pattern="hh:mm:ss a")
	private Date time;
	
	@Transient
	private MultipartFile attachFile;
	
	@NotNull
	private String subject;
	
	
	public Date getTime() {
		return time;
	}

	public Date setTime(Date time) {
		return this.time = time;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	
	public Feedback() {

	}

	public Feedback(@NotNull String name, @NotNull @Email String email, @NotNull String feedback, Date time, @NotNull String subject, MultipartFile attachFile) {
		
		this.name = name;
		this.email = email;
		this.feedback = feedback;
		this.time = time;
		this.subject = subject;
		this.attachFile = attachFile;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + name + ",attachFile=" + attachFile + ", email=" + email + ", feedback=" + feedback + ", time="+ time +",subject="+ subject +"]";
	}

	public MultipartFile getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(MultipartFile attachFile) {
		this.attachFile = attachFile;
	}
	
	
}
