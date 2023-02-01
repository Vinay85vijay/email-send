package com.sendmail.Resignation.Mail.service;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TestEmailService {
	
@Bean
	public EmailService emailService() {
		
		return Mockito.mock(EmailService.class);
		
	}
@Bean
public EmailServiceImpl emailServiceImplTest() {
	 return Mockito.mock(EmailServiceImpl.class);
}

}
