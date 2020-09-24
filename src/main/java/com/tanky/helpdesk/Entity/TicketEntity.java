package com.tanky.helpdesk.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	private String technicianId;
	private String technicianName;
	
	@OneToMany(mappedBy="ticket")
	private List<StatusEntity> statusEntity;
	
	
	@ManyToMany(mappedBy = "tickets")
	private List<UserEntity> books = new ArrayList<UserEntity>();
	
	
	public TicketEntity() {
		// TODO Auto-generated constructor stub
	}


	public TicketEntity(long id, String title, String startDate, String endDate, String image, String technicianId,
			String technicianName, List<StatusEntity> statusEntity, List<UserEntity> books) {
		super();
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.image = image;
		this.technicianId = technicianId;
		this.technicianName = technicianName;
		this.statusEntity = statusEntity;
		this.books = books;
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


	public String getTechnicianId() {
		return technicianId;
	}


	public void setTechnicianId(String technicianId) {
		this.technicianId = technicianId;
	}


	public String getTechnicianName() {
		return technicianName;
	}


	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}


	public List<StatusEntity> getStatus() {
		return statusEntity;
	}


	public void setStatus(List<StatusEntity> statusEntity) {
		this.statusEntity = statusEntity;
	}


	public List<UserEntity> getBooks() {
		return books;
	}


	public void setBooks(List<UserEntity> books) {
		this.books = books;
	}

	
	
	
	
	
	
	
	
	
}
