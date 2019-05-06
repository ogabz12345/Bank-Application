package com.example.demo.trialUpload;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileRepository extends JpaRepository<UploadFileResponse, Long> {

	

	

}
