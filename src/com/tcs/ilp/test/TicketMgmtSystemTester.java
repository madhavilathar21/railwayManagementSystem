package com.tcs.ilp.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.ilp.bean.Passenger;
import com.tcs.ilp.bean.Ticket;
import com.tcs.ilp.bean.Train;
import com.tcs.ilp.exception.InvalidTrainException;
import com.tcs.ilp.exception.LimitExceededException;
import com.tcs.ilp.exception.TicketAlreadyExistException;
import com.tcs.ilp.exception.TicketDoesNotPresentException;
import com.tcs.ilp.service.RailwayTicketManagement;

public class TicketMgmtSystemTester {
	public static void main(String[] args) {
		RailwayTicketManagement rms=new RailwayTicketManagement();
		
		Ticket t1=new Ticket(10001,250.00);
		t1.addPassenger("Anoop", "M", "Trivandrum", "Chennai", 37);
		Ticket t2=new Ticket(10002,250.00);
		t2.addPassenger("Resmi", "F", "Trivandrum", "Chennai", 37);
		Ticket t3=new Ticket(10003,550.00);
		t3.addPassenger("Ajay", "M", "Trivandrum", "Mumbai", 59);
		Ticket t4=new Ticket(10004,450.00);
		t4.addPassenger("Kishore", "M", "Trivandrum", "Panaji", 25);
		
		ArrayList<Ticket> ticketList=new ArrayList<Ticket>();
		ticketList.add(t1);
		ticketList.add(t2);
		ticketList.add(t3);
		
		Train tr1=new Train(6987, "Trivandrum", "Mumbai");
		tr1.setTicketList(ticketList);
		
		ArrayList<Train> trainList=new ArrayList<Train>();
		trainList.add(tr1);
		
		rms.setTrainList(trainList);
		
		try {
			boolean t=rms.issueTicket(6987, t4);
			System.out.println("Issue Status:"+t);
			
			HashMap<Integer, Integer> map=rms.getCountOfSeniorCitizens();
			
			t=rms.cancelTicket(6987, 10001);
			System.out.println("Cancel Status:"+t);
			
			ArrayList<Passenger> passengerList=rms.getPassengersByGender("F");
			for(Passenger p:passengerList) {
				System.out.println(p);
			}
			
			
		} catch(TicketAlreadyExistException e) {
			System.out.println(e.getMessage());
		} catch(LimitExceededException e) {
			System.out.println(e.getMessage());
		} catch(TicketDoesNotPresentException e) {
			System.out.println(e.getMessage());
		} catch(InvalidTrainException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
