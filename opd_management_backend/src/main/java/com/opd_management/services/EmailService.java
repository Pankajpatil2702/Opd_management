package com.opd_management.services;

import com.opd_management.dtos.EmailRequest;

public interface EmailService {
	
	String sendEmail(EmailRequest emailRequest);

}
