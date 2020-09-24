package com.tanky.helpdesk.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class StatusEntity {

	@Id
	private long id;
	private String state;
	private Date time;
	
	@ManyToOne
    @JoinColumn(name="ticket_id", nullable=false)
    private TicketEntity ticketEntity;
	
	public StatusEntity() {
		// TODO Auto-generated constructor stub
	}

	public StatusEntity(String state, Date time) {
		super();
		this.state = state;
		this.time = time;
	}
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TicketEntity getTicket() {
		return ticketEntity;
	}

	public void setTicket(TicketEntity ticketEntity) {
		this.ticketEntity = ticketEntity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
}
