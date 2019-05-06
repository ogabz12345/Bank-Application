package com.example.demo.uploadFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/bank")
@CrossOrigin(origins="*")

public class UplodController {
	@Autowired
	private UploadRepository uploadRepository;
	
private String UploadDir = "C:\\Users\\USER\\Desktop\\BANKAPP\\Back\\BankApplication\\src\\main\\resources\\uploadDir";
	
	@PostMapping("/uploaded")
	public UploadPath uploadFiles(@RequestParam("file") MultipartFile file, UploadPath up) throws IOException {
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(UploadDir)
                .path(file.getOriginalFilename())
                .toUriString();
		 saveUploadedFiles(file);
		 System.out.println("ffffffffffffffffffffffffffff"+file.getOriginalFilename());
		 up.setFileName(file.getOriginalFilename());
		 up.setFilePath(UploadDir);
		 up.setDownloadUri(fileDownloadUri);
		 return uploadRepository.save(up);
	}
	
	
	private String saveUploadedFiles(MultipartFile file) throws IOException  {
		
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UploadDir +"/" + file.getOriginalFilename());
		Files.write(path, bytes);
		return path.toString();
	}
	
	
	@GetMapping("/uploads")
	private List<UploadPath> getUploads(){
		return uploadRepository.findAll();
	}
	
	
	@GetMapping("/upload/{id}")
	private UploadPath getUpload(@PathVariable Long id) {
		return uploadRepository.getOne(id);
	}
}
