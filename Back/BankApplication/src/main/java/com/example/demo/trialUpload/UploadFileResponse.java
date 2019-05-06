package com.example.demo.trialUpload;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UploadFileResponse {

		
	@Id
	@GeneratedValue
	private Long id;
    private String fileName;
	private String fileDownloadUri;
    private String fileType;
    private Long fileSize;
    
    
    public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long fileSize) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

	@Override
	public String toString() {
		return "UploadFileResponse [id=" + id + ", fileName=" + fileName + ", fileDownloadUri=" + fileDownloadUri
				+ ", fileType=" + fileType + ", fileSize=" + fileSize + "]";
	}

	public UploadFileResponse() {
	}
    
    

	
}