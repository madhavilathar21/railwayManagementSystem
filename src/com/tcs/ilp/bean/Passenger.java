package com.tcs.ilp.bean;

public class Passenger {
	String name;
	String gender;
	String source;
	String destination;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Passenger(String name, String gender, String source, String destination) {
		super();
		this.name = name;
		this.gender = gender;
		this.source = source;
		this.destination = destination;
	}
	public Passenger() {
		super();
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", gender=" + gender + ", source=" + source + ", destination=" + destination
				+ "]";
	}
	
}
