package com.esprit.bookstore.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.bookstore.entities.MailObject;
import com.esprit.bookstore.services.EmailService;





@RestController
@RequestMapping("/mail")
public class MailController {
	
	
	@Autowired
    public EmailService emailService;


@PostMapping("/sendsimple")
public String notifierReduction()
{
	emailService.sendSimpleMessage("mohamedhoumem.ayari@esprit.tn", "reduction", "great news , nous avons des nouveaux reductions");
	return "mail envoyée";
}
}