package com.sendmail.Resignation.Mail.dto;

import java.util.List;

import jakarta.mail.internet.InternetAddress;

public class EmailRequestDto {
    private String from;
    private List<String> toMailId;
    private String toSimpleMailId;
    private List<String> bccMailId;
    private List<String> ccMailId;
    private String message;
    private String subject;
    
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getToMailId() {
		return toMailId;
	}
	public void setToMailId(List<String> toMailId) {
		this.toMailId = toMailId;
	}
	public String getToSimpleMailId() {
		return toSimpleMailId;
	}
	public void setToSimpleMailId(String toSimpleMailId) {
		this.toSimpleMailId = toSimpleMailId;
	}
	public  List<String> getBccMailId() {
		return bccMailId;
	}
	public void setBccMailId(List<String> bccMailId) {
		this.bccMailId = bccMailId;
	}
	public List<String> getCcMailId() {
		return ccMailId;
	}
	public void setCcMailId(List<String> ccMailId) {
		this.ccMailId = ccMailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
