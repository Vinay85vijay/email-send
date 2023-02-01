package com.sendmail.Resignation.Mail.util;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendmail.Resignation.Mail.dto.EmailRequestDto;
import com.sendmail.Resignation.Mail.dto.UserDetails;



@Component
public class EmailCommonUtil {



    @Autowired
    private ObjectMapper objectMapper;


    public EmailRequestDto convert(String data) throws JsonProcessingException {
       return objectMapper.readValue(data, EmailRequestDto.class);
    
    }
    public UserDetails convert1(String userDetails) throws JsonProcessingException {
        return objectMapper.readValue(userDetails, UserDetails.class);
     
     }
}
