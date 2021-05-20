package com.tcs.ilp.bean;

import java.util.ArrayList;

public class Train {
	int trainNo;
	String start;
	String destination;
	ArrayList<Ticket> ticketList;
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public ArrayList<Ticket> getTicketList() {
		return ticketList;
	}
	public void setTicketList(ArrayList<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
	public Train(int trainNo, String start, String destination) {
		super();
		this.trainNo = trainNo;
		this.start = start;
		this.destination = destination;
	}
	public Train() {
		super();
	}
	@Override
	public String toString() {
		return "Train [trainNo=" + trainNo + ", start=" + start + ", destination=" + destination + ", ticketList="
				+ ticketList + "]";
	}
	
}
