package com.tcs.ilp.bean;

public class SeniorCitizen extends Passenger {
	int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public SeniorCitizen(String name, String gender, String source, String destination, int age) {
		super(name, gender, source, destination);
		this.age = age;
	}

	public SeniorCitizen() {
		super();
	}

	@Override
	public String toString() {
		return "SeniorCitizen [age=" + age + ", name=" + name + ", gender=" + gender + ", source=" + source
				+ ", destination=" + destination + "]";
	}
	
}
