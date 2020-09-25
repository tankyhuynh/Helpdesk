package com.tanky.helpdesk.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "status")
public class StatusEntity {

	@Id
	private long id;
	private String state;
	private Date time;

//	@ManyToOne
//    @JoinColumn(name="ticket_id", nullable=false)
//    private TicketEntity ticketStatus;

	@ManyToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = { "status" })
	private List<TicketEntity> ticketStatus = new ArrayList<TicketEntity>();

	public StatusEntity() {
		// TODO Auto-generated constructor stub
	}

	public StatusEntity(long id, String state, Date time, List<TicketEntity> ticketStatus) {
		super();
		this.id = id;
		this.state = state;
		this.time = time;
		this.ticketStatus = ticketStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<TicketEntity> getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(List<TicketEntity> ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

}
