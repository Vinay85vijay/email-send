 package com.sendmail.Resignation.Mail.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sendmail.Resignation.Mail.dto.EmailRequestDto;
import com.sendmail.Resignation.Mail.dto.UserDetails;
import com.sendmail.Resignation.Mail.response.ResponseEmail;
import com.sendmail.Resignation.Mail.service.EmailService;
import com.sendmail.Resignation.Mail.util.EmailCommonUtil;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")

public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailCommonUtil commonUtil;
   
    @PostMapping("/sendmail")
    public ResponseEmail sendEmail(@RequestParam("userDetails") String userDetails, @RequestParam("data")String request)throws Exception{
    	EmailRequestDto requestDto = commonUtil.convert(request);
    	UserDetails details = commonUtil.convert1(userDetails);
    //	System.out.println(userDetails.getName());
      //  System.out.println("file name *****  "+multipartFile.getName()+"   file size ******** "+multipartFile.getSize()+"  email *** "+requestDto.getSubject());
        ResponseEmail data = emailService.sendEmailWithAttachment(requestDto, details);

      // String data =   emailService.sendSimpleMail(requestDto);
        return data;
    }
   


    @PostMapping("/sendsimplemail")
    public ResponseEntity<String>sendEmail( @RequestBody EmailRequestDto requestDto,@RequestBody UserDetails userDetails)throws Exception{

     //   System.out.println("file name *****  "+multipartFile.getName()+"   file size ******** "+multipartFile.getSize()+"  email *** "+requestDto.getSubject());
        //String data = emailService.sendEmailWithAttachment(requestDto,multipartFile);

        String data =   emailService.sendSimpleMail(requestDto, userDetails);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    
}

