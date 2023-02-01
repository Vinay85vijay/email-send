//package com.sendmail.Resignation.Mail.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.sendmail.Resignation.Mail.ResignationMailApplication;
//import com.sendmail.Resignation.Mail.dto.EmailRequestDto;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = { ResignationMailApplication.class })
//public class EmailServiceImplTest {
//	
//	
//	@Autowired
//	EmailServiceImpl serviceImp;
//	@Autowired
//	EmailService emailService;
//	@Autowired
//	JavaMailSender emailSender;
//	@Autowired
//	EmailRequestDto emailDto;
//	
//	
// private EmailRequestDto TestService() throws Exception  {
//		
//	 List<String> toMailId = new ArrayList<>();
//	 toMailId.add("vvinnu48@gmail.com");
//	 List<String> bccMailId = new ArrayList<>();
//	 bccMailId.add("vinaygouda@mirafra.com");
//	 EmailRequestDto email = new EmailRequestDto();
//	 email.setFrom( "Employee  <noreply@springboot.com>"); 
//	 email.setBccMailId(bccMailId);
//	 email.setToMailId(toMailId);
//	 email.setSubject("test mail");
//	 email.setMessage("this is a simple mail");
//	 
//	return email;
//	 
//
// }
// @Test
// public void test1() throws Exception {
//	 EmailRequestDto email = TestService();
//	// String sendEmailWithAttachment = emailService.sendEmailWithAttachment(email);
////	 assertThat(sendEmailWithAttachment).isEqualTo(sendEmailWithAttachment);
// }
// private  EmailRequestDto simplemail() {
//	 List<String> toMailId = new ArrayList<>();
//	 toMailId.add("vvinnu48@gmail.com");
//	 EmailRequestDto email = new EmailRequestDto();
////	 email.setFrom( " noreply@springboot.com"); 
//	 email.setMessage("this is a simple mail");
//	 email.setToMailId(toMailId);
//	 email.setSubject("test mail");
//	 email.setToSimpleMailId("simple");
//	return email;
// }
// 
//@Test
// public void test2() throws Exception {
//	 EmailRequestDto email =simplemail() ;
//	// String sendEmail = emailService.sendSimpleMail(email);
//	 assertThat(sendEmail).isEqualTo(sendEmail);
// }
// 
//}
