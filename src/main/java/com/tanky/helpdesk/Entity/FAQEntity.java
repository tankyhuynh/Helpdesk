package com.tanky.helpdesk.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class FAQEntity {

	@Id
	private long id;
	
	@Column(columnDefinition = "TEXT")
	private String question;
	
	@Column(columnDefinition = "TEXT")
	private String answer;
	
	public FAQEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FAQEntity(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
	
	
}
