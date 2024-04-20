package com.Project;


public class RailwayCrossing {
	private String name;
	private String address;
	private String landmark;
	private String trainSchedule;
	private String personInCharge;
	private String crossing_status;
	public RailwayCrossing() {
	super();
	// TODO Auto-generated constructor stub
	}
	public RailwayCrossing(
			 String name, String address, String
	landmark, String trainSchedule,
	String personInCharge, String status) {
	super();
	this.name = name;
	this.address = address;
	this.landmark = landmark;
	this.trainSchedule = trainSchedule;
	this.personInCharge = personInCharge;
	this.crossing_status = status;
	}
	
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getAddress() {
	return address;
	}
	public void setAddress(String address) {
	this.address = address;
	}
	public String getLandmark() {
	return landmark;
	}
	public void setLandmark(String landmark) {
	this.landmark = landmark;
	}
	public String getTrainSchedule() {
	return trainSchedule;
	}
	public void setTrainSchedule(String trainSchedule) {
	this.trainSchedule = trainSchedule;
	}
	public String getPersonInCharge() {
	return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
	this.personInCharge = personInCharge;
	}
	public String getCrossing_Status() {
	return crossing_status;
	}
	public void setCrossing_Status(String crossing_status) {
	this.crossing_status = crossing_status;
	}
	
	}