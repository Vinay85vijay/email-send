package com.sendmail.Resignation.Mail.service;

import com.sendmail.Resignation.Mail.dto.EmailRequestDto;
import com.sendmail.Resignation.Mail.dto.UserDetails;
import com.sendmail.Resignation.Mail.response.ResponseEmail;

public interface EmailService {

    public ResponseEmail sendEmailWithAttachment(EmailRequestDto emailDto,UserDetails userDetails)throws Exception;
    public String sendSimpleMail(EmailRequestDto details,UserDetails userDetails);
    
    
}
