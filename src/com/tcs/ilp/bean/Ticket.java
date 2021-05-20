package com.tcs.ilp.bean;

public class Ticket {
	int ticketNo;
	double price;
	Passenger passenger;
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Ticket(int ticketNo, double price) {
		super();
		this.ticketNo = ticketNo;
		this.price = price;
	}
	public Ticket() {
		super();
	}
	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", price=" + price + ", passenger=" + passenger + "]";
	}
	
	public void addPassenger(String name, String gender, String source, String destination, int age) {
		if(age>55) {
			passenger=new SeniorCitizen(name, gender, source, destination, age);
		} else {
			passenger=new Passenger(name, gender, source, destination);
		}
	}
}
