package com.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Query {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private LocalDate answerCreatedAt;
	private String answer;
	private LocalDate queryCreatedDate;
	private String userfeedback;
	private LocalDate feedBacakDate;
	
	public Query() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Query(int id, String question, String answer,  String userfeedback) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.userfeedback = userfeedback;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
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
//	public int getUid() {
//		return uid;
//	}
//	public void setUid(int uid) {
//		this.uid = uid;
//	}
	public String getUserfeedback() {
		return userfeedback;
	}
	public void setUserfeedback(String userfeedback) {
		this.userfeedback = userfeedback;
	}

	public LocalDate getQueryCreatedDate() {
		return queryCreatedDate;
	}

	public void setQueryCreatedDate(LocalDate queryCreatedDate) {
		this.queryCreatedDate = queryCreatedDate;
	}

	public LocalDate getFeedBacakDate() {
		return feedBacakDate;
	}

	public void setFeedBacakDate(LocalDate feedBacakDate) {
		this.feedBacakDate = feedBacakDate;
	}

	public LocalDate getAnswerCreatedAt() {
		return answerCreatedAt;
	}

	public void setAnswerCreatedAt(LocalDate answerCreatedAt) {
		this.answerCreatedAt = answerCreatedAt;
	}

	
	
	
	

}
