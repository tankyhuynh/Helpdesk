package com.tanky.helpdesk.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ticket")
public class TicketEntity {

	@Id
	private long id;
	private String title;
	private String startDate;
	private String endDate;
//	private String detail;
	private String image;
//	private String place;

//	@OneToMany(mappedBy="ticketStatus")
//	@JsonIgnore
//	private List<StatusEntity> status = new ArrayList<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ticket_status", joinColumns = @JoinColumn(name = "ticket_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
	@JsonIgnoreProperties(value = { "users" })
	private List<StatusEntity> status = new ArrayList<StatusEntity>();

	@ManyToMany(mappedBy = "tickets", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = { "users" })
	private List<UserEntity> users = new ArrayList<UserEntity>();

	public TicketEntity() {
		// TODO Auto-generated constructor stub
	}

	public TicketEntity(long id, String title, String startDate, String endDate, String image,
			List<StatusEntity> status, List<UserEntity> users) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.image = image;
		this.status = status;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<StatusEntity> getStatus() {
		return status;
	}

	public void setStatus(List<StatusEntity> status) {
		this.status = status;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

}
