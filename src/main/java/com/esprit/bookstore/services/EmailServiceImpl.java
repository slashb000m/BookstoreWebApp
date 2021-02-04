package com.esprit.bookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImpl implements EmailService{

	
		@Autowired
	    private JavaMailSender emailSender;

	
		@Override
		public void sendSimpleMessage(String to, String subject, String text) {


			

		        SimpleMailMessage msg = new SimpleMailMessage();
		        msg.setTo(to);

		        msg.setSubject(subject);
		        msg.setText(text);

		        emailSender.send(msg);
	    
	

	
			
		}
}
