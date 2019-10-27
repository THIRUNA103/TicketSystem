package com.naren.TicketBookingMysql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.naren.TicketBookingMysql.dao.TicketBookingDao;
import com.naren.TicketBookingMysql.entity.Ticket;

@Service
public class TicketBookingService {

	
	@Autowired
	TicketBookingDao ticketBookingDao;
	
	public Ticket create(Ticket t) {
		return ticketBookingDao.save(t);

		// TODO Auto-generated method stub
		
	}

	public Iterable<Ticket> getallTickets() {
		
		return ticketBookingDao.findAll();
		// TODO Auto-generated method stub
		
	}

	public Optional<Ticket> getTicketById(Integer ticketId) {
		// TODO Auto-generated method stub
		return ticketBookingDao.findById(ticketId);
	}

	public void deleteByTicketId(Integer ticketId) {
		// TODO Auto-generated method stub
		 ticketBookingDao.deleteById(ticketId);;
	}

	public List<Ticket> getTicketBydestName(String destName) {
		// TODO Auto-generated method stub
		return ticketBookingDao.getByDestName(destName);
	}

	public Iterable<Ticket> getallTicketsByEmail(String email) {
		// TODO Auto-generated method stub
		return ticketBookingDao.findByEmial(email);
	}

	public List<Ticket> getallTicketsPagination(Pageable p) {
		// TODO Auto-generated method stub
		 Page<Ticket> findAll = ticketBookingDao.findAll(p);
		 if(findAll.hasContent()) {
			 return findAll.getContent();
		 }else {
			 return new ArrayList<Ticket>();
		 }
	}

	
	

}
