package com.naren.TicketBookingMysql;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.naren.TicketBookingMysql.entity.Ticket;
import com.naren.TicketBookingMysql.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingApplication implements CommandLineRunner{

	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	public static void main(String[] args) {
//		SpringApplication.run(TicketBookingApplication.class, args);
		SpringApplication springApplication= new SpringApplication(TicketBookingApplication.class);
		springApplication.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		Ticket t= new Ticket();
//		t.setPassengerName("Nani");
//		t.setBookingDate(new Date());
//		t.setSourcName("Hyd");
//		t.setDestName("Bangalore");
//		t.setEmial("naren@gmail.com");
//		
//		ticketBookingService.create(t);
//		
	}

}
