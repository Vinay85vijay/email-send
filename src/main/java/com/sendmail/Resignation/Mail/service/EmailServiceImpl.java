package com.sendmail.Resignation.Mail.service; 



import java.io.File;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sendmail.Resignation.Mail.dto.EmailRequestDto;
import com.sendmail.Resignation.Mail.dto.UserDetails;
import com.sendmail.Resignation.Mail.response.ResponseEmail;

import jakarta.mail.SendFailedException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
@Autowired
private JavaMailSender emailSender;
@Autowired
private UserDetails userDetails;

    public ResponseEmail sendEmailWithAttachment(EmailRequestDto emailDto,UserDetails userDetails) throws Exception{
    	ResponseEmail responseEmail=new ResponseEmail();
        try {
        	
        	userDetails.setEmpId(userDetails.getEmpId());
        	userDetails.setName(userDetails.getName());
        	userDetails.setNoticePeriod(userDetails.getNoticePeriod());
        	userDetails.setPosition(userDetails.getPosition());
        	userDetails.setReasons(userDetails.getReasons());
        	
        	
        	
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true,"utf-8"); 
			helper.setFrom( new InternetAddress("Employee <noreply@springboot.com>"));
			//helper.set
			helper.setSubject(emailDto.getSubject());
			
			
			helper.setText("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Resignation Submitted </title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ " <h2>I would like to inform you that I "+userDetails.getName()+" with Employee Id "+userDetails.getEmpId()+""
					+ "<br>working as a "+ userDetails.getPosition()+" in your company,<br>"
					+ " would like to submit my formal resignation,"
					+ "<br> effective "+LocalDate.now()+". I am resigning with such short notice due"
					+ " <br> to  "+ userDetails.getReasons()+"  and my Notice period is "+userDetails.getNoticePeriod() + " .<br>"
					+ " I apologize for the inconvenience of the matter, "
					+ "<br> but I hope you can understand my urgency.</h2>\r\n"
					
					+ "</body>\r\n"  
					+ "</html>",true);
			
			//emailDto.getBccMailId()!=null && !emailDto.getBccMailId().isEmpty()
			
      if(Objects.nonNull(emailDto.getBccMailId()) && !CollectionUtils.isEmpty(emailDto.getBccMailId())){ 
			    System.out.println("inside  bcc email");
	 		String[] bccEmail =  emailDto.getBccMailId().toArray(String[]::new);
			//    InternetAddress[] bccEmail=emailDto.getBccMailId();
			helper.setBcc(bccEmail);
			}
			if(Objects.nonNull(emailDto.getCcMailId()) && !CollectionUtils.isEmpty(emailDto.getCcMailId())){
			    System.out.println("inside  cc email");
			 String[] ccEmail =  emailDto.getCcMailId().toArray(String[]::new);
			  helper.setCc(ccEmail);
      }
			if(emailDto.getToMailId()!=null && !emailDto.getToMailId().isEmpty() ){
			    System.out.println("inside  to email");
			    String[] toEmail =  emailDto.getToMailId().toArray(String[]::new);
			//    InternetAddress[] toEmail=emailDto.getBccMailId();
			    helper.setTo(toEmail);
			}
			FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Admin\\Downloads\\mirafra Logo.jpg"));
			helper.addAttachment(file.getFilename(), file);
			
		
			emailSender.send(message);
			responseEmail.setStatus(true);
			responseEmail.setMessage("Email sent successfully!");
			responseEmail.setCode(HttpStatus.OK);
			return responseEmail;
		} catch ( SendFailedException | MailSendException ex) {
			// TODO Auto-generated catch block
			responseEmail.setStatus(false);
			responseEmail.setMessage("Email not sent ");
			responseEmail.setCode(HttpStatus.FORBIDDEN);
			 return responseEmail;
		} 
    }

// public UserDetails userInformation() {
//    userDetails.setName(( userDetails).getName()); 
//    userDetails.setEmpId(userDetails.getEmpId());
//    userDetails.setNoticePeriod(userDetails.getNoticePeriod());
//    userDetails.setPosition(userDetails.getPosition());
//    userDetails.setReasons(userDetails.getReasons());
//	return userDetails;
// }
		
	



    // To send a simple email
    public String sendSimpleMail(EmailRequestDto details,UserDetails userDetails)
    {


        try {
        	userDetails = new UserDetails();
        	userDetails.setEmpId(userDetails.getEmpId());
        	userDetails.setName(userDetails.getName());
        	userDetails.setNoticePeriod(userDetails.getNoticePeriod());
        	userDetails.setPosition(userDetails.getPosition());
        	userDetails.setReasons(userDetails.getReasons());

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("v.gouda85@gmail.com");
            mailMessage.setTo(details.getToSimpleMailId());
            mailMessage.setText(details.getMessage());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            emailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

}

