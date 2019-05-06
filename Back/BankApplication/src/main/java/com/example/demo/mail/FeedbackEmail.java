package com.example.demo.mail;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;

import com.example.demo.uploadFiles.UploadPath;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FeedbackEmail {
private String name;
	
@Id
@GeneratedValue
private Long id;
	@Email
	private String email;
	private String feedback;
	
	@JsonFormat(pattern="hh:mm:ss a")
	private Date time;
	
	private String subject;
	@Lob
	private byte[] sentFile;
	
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

	public FeedbackEmail() {
	}

	public FeedbackEmail(String name, @Email String email, String feedback, Date time, String subject, byte[] sentFile) {
		super();
		this.name = name;
		this.email = email;
		this.feedback = feedback;
		this.time = time;
		this.subject = subject;
		this.sentFile=sentFile;
	}
	public byte[] getSentFile() {
		return sentFile;
	}
	public byte[] setSentFile(byte[] fileNames) {
		return this.sentFile = fileNames;
	}
	
	
}
