package com.Jira.Application.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class LogIn {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
   @Column(name="email_id")
	private String emailId;
	private String password;
	private String fullName;
	public LogIn(long userId, String emailId, String password, String fullName) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.password = password;
		this.fullName = fullName;
	}
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}
