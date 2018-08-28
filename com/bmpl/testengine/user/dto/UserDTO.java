package com.bmpl.testengine.user.dto;

import java.io.Serializable;

//UserDTO is basically used to transfer the multiple objects 
//This class is used because to send data to helper
public class UserDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String password;
	private String phoneno;
	private String gender;
	private String person;
	private String enrolID;
	private String emailID;
	

	//setters and getters are generated here
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getEnrolID() {
		return enrolID;
	}
	public void setEnrolID(String enrolID) {
		this.enrolID = enrolID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", password=" + password + ", phoneno=" + phoneno + ", gender=" + gender
				+ ", person=" + person + ", enrolID=" + enrolID + ", emailID=" + emailID + "]";
	}
	
}
