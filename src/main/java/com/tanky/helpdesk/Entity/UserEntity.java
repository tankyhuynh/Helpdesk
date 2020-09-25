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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	private long id;
	private String username;
	private String password;
	private String fullName;
	private String role;
//	private String image;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_ticket", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ticket_id"))
	@JsonIgnoreProperties(value = {"users"})
	private List<TicketEntity> tickets = new ArrayList<TicketEntity>();


	public UserEntity() {
		// TODO Auto-generated constructor stub
	}


	public UserEntity(long id, String username, String password, String fullName, String role, String image,
			List<TicketEntity> tickets) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
//		this.image = image;
		this.tickets = tickets;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


//	public String getImage() {
//		return image;
//	}
//
//
//	public void setImage(String image) {
//		this.image = image;
//	}


	public List<TicketEntity> getTickets() {
		return tickets;
	}


	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}

	
	
	
	
	

}
