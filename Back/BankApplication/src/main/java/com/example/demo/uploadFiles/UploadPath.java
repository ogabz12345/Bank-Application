package com.example.demo.uploadFiles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "upload")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UploadPath {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String filePath;
	private String fileName;
	private String DownloadUri;
	
	public String getDownloadUri() {
		return DownloadUri;
	}
	public void setDownloadUri(String DownloadUri) {
		this.DownloadUri = DownloadUri;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public UploadPath(String filePath, String fileName, String DownloadUri) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.DownloadUri= DownloadUri;
	}
	public UploadPath() {
	}
	@Override
	public String toString() {
		return "UploadPath [id=" + id + ", filePath=" + filePath + ", DownloadUri=" + DownloadUri + " , fileName=" + fileName + "]";
	}
	
	
	
	
	
}
