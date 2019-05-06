package com.example.demo.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FeedbackController {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	private JavaMailSender javaMailSender;

	@Autowired
	public FeedbackController(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


//	private EmailConfig emailConfig;
//	
//	public FeedbackController(EmailConfig emailConfig) {
//		this.emailConfig = emailConfig;
//	}
	
	@GetMapping("/feedbacks")
	public List<FeedbackEmail> findAll(){
		return feedbackRepository.findAll();
	}
	
	@DeleteMapping("/feedback/{id}")
	public boolean delete(@PathVariable Long id) {
		feedbackRepository.deleteById(id);
		return true;
	}
	
	@PostMapping("/feedback")
	public FeedbackEmail sendFeedback(@RequestPart("contact") FeedbackEmail feedback, @RequestPart(value = "file", required = false) MultipartFile[] file) throws MessagingException {

		//create an email instance
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setFrom("spring.mail.username");
//		mailMessage.setTo(feedback.getEmail());
//		mailMessage.setSubject(feedback.getSubject());
//		mailMessage.setText(feedback.getFeedback());
//		mailMessage.setSentDate(feedback.setTime(new Date()));
		
		System.out.println(feedback.getEmail());
		System.out.println("File Name " + file.length);
		
//		email instance with attachment
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("spring.mail.username");
		helper.setTo(feedback.getEmail());
		helper.setSubject(feedback.getSubject());
		Date n = new Date();
		feedback.setTime(n);
		helper.setText(feedback.getFeedback());
		
		helper.setSentDate(n);
		byte[] fileNames = null;
		String fileName = null;
		if(file != null ) {
			for (MultipartFile multipartFile : file) {
				 try {
					fileNames = multipartFile.getBytes();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 fileName = multipartFile.getOriginalFilename();
				helper.addAttachment(fileName, multipartFile);
				//helper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
			}
//			FileSystemResource file = new FileSystemResource(new File(feedback.getAttachment().getFilePath(), feedback.getAttachment().getFileName())); 
			
//			helper.addAttachment(file.getFilename(), file);
		}
		
				
			javaMailSender.send(mimeMessage);
			
			FeedbackEmail f = new FeedbackEmail();
			f.setEmail(feedback.getEmail());
			f.setFeedback(feedback.getFeedback());
			f.setName(feedback.getName());
			f.setTime(feedback.getTime());
			f.setSubject(feedback.getSubject());
			f.setSentFile(fileNames);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+fileNames);
			return feedbackRepository.save(f);
		}
		
}
