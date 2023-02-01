package com.sendmail.Resignation.Mail.dto;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
@Component
public class UserDetails {
	
	private  String name;
	private  int EmpId;
	private  String NoticePeriod;
	private  String Reasons;
	private  String Position;
	  LocalDate localDate = LocalDate.now();
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getNoticePeriod() {
		return NoticePeriod;
	}
	public void setNoticePeriod(String noticePeriod) {
		NoticePeriod = noticePeriod;
	}
	public String getReasons() {
		return Reasons;
	}
	public void setReasons(String reasons) {
		Reasons = reasons;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", EmpId=" + EmpId + ", NoticePeriod=" + NoticePeriod + ", Reasons="
				+ Reasons + ", Position=" + Position + ", localDate=" + localDate + "]";
	}
	


	
	

	
	

}
