package com.sendmail.Resignation.Mail.response;

import org.springframework.http.HttpStatus;


public class ResponseEmail {
	
	boolean status ;
	String message ;
	HttpStatus code;
	public ResponseEmail() {
		
	}
	public ResponseEmail(boolean status, String message, HttpStatus code) {
		super();
		this.status = status;
		this.message = message;
		this.code = code;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getCode() {
		return code;
	}
	public void setCode(HttpStatus code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "ResponseEmail [status=" + status + ", message=" + message + ", code=" + code + "]";
	}
	
	

}
