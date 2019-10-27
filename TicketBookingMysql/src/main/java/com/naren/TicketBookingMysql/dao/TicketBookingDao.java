package com.naren.TicketBookingMysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naren.TicketBookingMysql.entity.Ticket;

public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {
	
	List<Ticket> getByDestName(String destName);
	List<Ticket> findByEmial(String email);

}
