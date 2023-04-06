package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String imageUrl;
	private String createdBy;
	private String level;
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Game(int id, String name, String createdby, String level) {
		super();
		this.id = id;
		this.name = name;
		createdBy = createdby;
		level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedby() {
		return createdBy;
	}
	public void setCreatedby(String createdby) {
		createdBy = createdby;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		level = level;
	}
	public String getImageurl() {
		return imageUrl;
	}
	public void setImageurl(String imageurl) {
		this.imageUrl = imageurl;
	}
	
	

}
