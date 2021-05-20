package com.tcs.ilp.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.tcs.ilp.bean.Passenger;
import com.tcs.ilp.bean.Ticket;
import com.tcs.ilp.exception.InvalidTrainException;
import com.tcs.ilp.exception.LimitExceededException;
import com.tcs.ilp.exception.TicketAlreadyExistException;
import com.tcs.ilp.exception.TicketDoesNotPresentException;

public interface RailwayTicketManagementInterface {
	public boolean issueTicket(int trainNo, Ticket t) throws TicketAlreadyExistException, 
		LimitExceededException;
	public HashMap<Integer, Integer> getCountOfSeniorCitizens();
	public boolean cancelTicket(int trainNo, int ticketNo) throws TicketDoesNotPresentException,
		InvalidTrainException;
	public ArrayList<Passenger> getPassengersByGender(String gender);
}
