package com.opd_management.servicesIMPLs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.opd_management.dtos.EmailRequest;
import com.opd_management.services.EmailService;

@Service
public class EmailServiceIMPL implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public String sendEmail(EmailRequest emailRequest) {
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setTo(emailRequest.getTo());
			message.setSubject(emailRequest.getSubject());
			message.setText(emailRequest.getMessage());
			
			mailSender.send(message);
			
			return "Email sent successfully to " + emailRequest.getTo();
		} catch (Exception e) {
			
			return "Error while sending email: " + e.getMessage();
		}
		
	}

}
