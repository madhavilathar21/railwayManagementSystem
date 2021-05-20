package com.tcs.ilp.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.ilp.bean.Passenger;
import com.tcs.ilp.bean.SeniorCitizen;
import com.tcs.ilp.bean.Ticket;
import com.tcs.ilp.bean.Train;
import com.tcs.ilp.exception.InvalidTrainException;
import com.tcs.ilp.exception.LimitExceededException;
import com.tcs.ilp.exception.TicketAlreadyExistException;
import com.tcs.ilp.exception.TicketDoesNotPresentException;

public class RailwayTicketManagement implements RailwayTicketManagementInterface  {
	ArrayList<Train> trainList;
	
	public ArrayList<Train> getTrainList() {
		return trainList;
	}

	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}

	public boolean issueTicket(int trainNo, Ticket t) throws TicketAlreadyExistException, 
		LimitExceededException {
		boolean result=false;
		for(Train tr:trainList) {
			if(tr.getTrainNo()==trainNo) {
				for(Ticket tk:tr.getTicketList()) {
					if(tk.getTicketNo()==t.getTicketNo()) {
						throw new TicketAlreadyExistException("Ticket with no="+ t.getTicketNo() +" alsready exists!!!");
					}
				}
				if(tr.getTicketList().size()<500) {
					tr.getTicketList().add(t);
					result=true;
					break;
				} else {
					throw new LimitExceededException("Ticket already full!!!");
				}
			}
		}
		return result;
	}
	
	public HashMap<Integer, Integer> getCountOfSeniorCitizens() {
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(Train tr:trainList) {
			int count=0;
			for(Ticket tt:tr.getTicketList()) {
				if(tt.getPassenger()!=null) {
					if(tt.getPassenger() instanceof SeniorCitizen) {
						count++;
					}
				}
			}
			map.put(tr.getTrainNo(), count);
		}
		return map;
	}
	
	public boolean cancelTicket(int trainNo, int ticketNo) throws TicketDoesNotPresentException,
		InvalidTrainException {
		boolean result=false;
		for(Train tr:trainList) {
			if(tr.getTrainNo()==trainNo) {
				Ticket temp=null;
				for(Ticket tk:tr.getTicketList()) {
					if(tk.getTicketNo()==ticketNo) {
						temp=tk;
						break;
					}
				}
				if(temp==null) {
					throw new TicketDoesNotPresentException("Ticket with no="+ ticketNo +" doesn not exist!!!");
				}
				tr.getTicketList().remove(temp);
				result=true;
				break;
			}
		}
		if(result==false) {
			throw new InvalidTrainException("Invalid train no!!!");
		}
		return result;
	}
	
	public ArrayList<Passenger> getPassengersByGender(String gender) {
		ArrayList<Passenger> passengerList=new ArrayList<Passenger>();
		for(Train tr:trainList) {
			for(Ticket tk:tr.getTicketList()) {
				if(tk.getPassenger()!=null && tk.getPassenger().getGender().equals(gender)) {
					passengerList.add(tk.getPassenger());
				}
			}
		}
		return passengerList;
	}
}
