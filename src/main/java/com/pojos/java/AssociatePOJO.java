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
	private int carDuringTraining;
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
		this.carDuringTraining = -1;
		this.email = null;
		this.phoneNumber = -1;
	}
	
	public AssociatePOJO(String username, String firstName, String lastName, 
			              String sex, String address, String city, String state,
			              int zip, int phoneNumber, Date date, String methodOfTrans,
			              int carDuringTraining, String email){
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
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param l the phoneNumber to set
	 */
	public void setPhoneNumber(long l) {
		this.phoneNumber = l;
	}
	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * @return the methodOfTrans
	 */
	public String getMethodOfTrans() {
		return methodOfTrans;
	}
	/**
	 * @param methodOfTrans the methodOfTrans to set
	 */
	public void setMethodOfTrans(String methodOfTrans) {
		this.methodOfTrans = methodOfTrans;
	}
	/**
	 * @return the carDuringTraining
	 */
	public int getCarDuringTraining() {
		return carDuringTraining;
	}
	/**
	 * @param carDuringTraining the carDuringTraining to set
	 */
	public void setCarDuringTraining(int carDuringTraining) {
		this.carDuringTraining = carDuringTraining;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}