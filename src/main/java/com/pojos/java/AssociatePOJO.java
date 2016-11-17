package com.pojos.java;

import java.util.Date;

public class AssociatePOJO {
	private String username;
	private String firstName;
	private String lastName;
	private String sex;
	private String address;
	private String city;
	private String state;
	private int zip;
	private Date arrivalDate;
	private String methodOfTrans;
	private String carDuringTraining;
	private String email;
	private long phoneNumber;
	
	public AssociatePOJO(){
		this.username = null;
		this.firstName = null;
		this.lastName = null;
		this.sex = null;
		this.address = null;
		this.city = null;
		this.state = null;
		this.zip = -1;
		this.arrivalDate = null;
		this.methodOfTrans = null;
		this.carDuringTraining = null;
		this.email = null;
		this.phoneNumber = -1;
	}
	
	public AssociatePOJO(String username, String firstName, String lastName, 
			              String sex, String address, String city, String state,
			              int zip, int phoneNumber, Date date, String methodOfTrans,
			              String carDuringTraining, String email){
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.arrivalDate = date;
		this.methodOfTrans = methodOfTrans;
		this.carDuringTraining = carDuringTraining;
		this.email = email;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getZip() {
		return zip;
	}
	
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long l) {
		this.phoneNumber = l;
	}
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	public String getMethodOfTrans() {
		return methodOfTrans;
	}
	
	public void setMethodOfTrans(String methodOfTrans) {
		this.methodOfTrans = methodOfTrans;
	}
	
	public String getCarDuringTraining() {
		return carDuringTraining;
	}
	
	public void setCarDuringTraining(String carDuringTraining) {
		this.carDuringTraining = carDuringTraining;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}