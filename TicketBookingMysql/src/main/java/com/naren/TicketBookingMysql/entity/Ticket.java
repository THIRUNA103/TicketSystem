package com.naren.TicketBookingMysql.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "ticket")
//@NamedQueries(value = {
//		@NamedQuery(name = "Ticket.findByEmail",query = "SELECT P FROM Ticket P WHERE P.passengerName=?1")
//})
@Data
public class Ticket {
	
	@Id
//	@SequenceGenerator(name = "mySeqGen",sequenceName = "mySeq",initialValue = 5,allocationSize = 1000)
//	@GeneratedValue(generator = "mySeqGen")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="passenger_name",nullable = false)
	private String passengerName;
	
	@Column(name="booking_date")
	private Date bookingDate;
	
	@Column(name="source_name")
	private String sourcName;
	
	@Column(name="dest_name")
	private String destName;
	
	@Column(name="email")
	private String emial;

}
