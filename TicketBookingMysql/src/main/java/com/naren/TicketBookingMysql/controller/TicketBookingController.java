package com.naren.TicketBookingMysql.controller;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.naren.TicketBookingMysql.service.TicketBookingService;
import com.naren.TicketBookingMysql.entity.Ticket;

@RestController
public class TicketBookingController implements ErrorController{
	
	
	@Autowired
	TicketBookingService ticketBookingService;
	
	@Value("${welcome.message}")
	private String msg;
	
	@GetMapping(value="/getAllTickets",produces =MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Ticket> getAllTickets() {
		 return ticketBookingService.getallTickets();
		
	}
	
	@GetMapping(value="/getAllTicketsbyEmail/{email}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Ticket> getAllTicketsByEmail(@PathVariable String email) {
		 return ticketBookingService.getallTicketsByEmail(email);
		
	}
	
	@GetMapping(value="/getByTicektId/{ticketId}")
	public Optional<Ticket> getByTicketId(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@GetMapping(value="/getBydestName/{destName}")
	public List<Ticket> getByTicketId(@PathVariable("destName") String destName) {
		return ticketBookingService.getTicketBydestName(destName);	}
	
	@PostMapping(value="/create")
	public Ticket create(@RequestBody Ticket t) {
		return ticketBookingService.create(t);
		
	}
	
	@PostMapping(value="/createMultipleTickets")
	public List<Ticket> createMultipleTicekts(@RequestBody List<Ticket> t) {
		
		List<Ticket> fin = new ArrayList<>();
		for(Ticket t1:t)
			fin.add(ticketBookingService.create(t1));
		
		return fin;
		
	}
	
	@DeleteMapping(value="/getDeleteticketById/{ticketId}")
	public void deleteByTicketId(@PathVariable("ticketId") Integer ticketId) {
		 ticketBookingService.deleteByTicketId(ticketId);
	}
	
	@GetMapping(value="/getAllTicketPagination",produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ticket>> getAllTicketPagination() {
		
		Pageable p=PageRequest.of(0,2,Sort.by("ticketId").descending());
		List<Ticket> list= ticketBookingService.getallTicketsPagination(p);
		return new ResponseEntity<List<Ticket>>(list, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/error",method =RequestMethod.GET)
	public String errorMessage() {
		return "Oops...Page Not found " + msg;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	
	
	

}
