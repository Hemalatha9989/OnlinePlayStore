package com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String username;
	@NotEmpty
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Enter a valid emailaddress!")
	private String email;
	@NotEmpty
	private String password;
	private int age;
	@NotEmpty
	private String role ="ROLE_USER";
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private List<PlayCard> playCards;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private List<Query> CustomerCare;
	public User() { 
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String email, String password, List<PlayCard> gameHistory) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		playCards = gameHistory;
		this.role="ROLE_USER";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<PlayCard> getPlayCards() {
		return playCards;
	}
	public void setPlayCards(List<PlayCard> playCards) {
		this.playCards = playCards;
	}
	public void AddPlaycard(PlayCard game) {
		if(playCards == null) {
			playCards = new ArrayList<PlayCard>();
		}
		playCards.add(game);
	}
	public void addQuestion(Query query) {
		if(CustomerCare == null) {
			CustomerCare = new ArrayList<Query>();
		}
		CustomerCare.add(query);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Query> getCustomerCare() {
		return CustomerCare;
	}
	public void setCustomerCare(List<Query> customerCare) {
		CustomerCare = customerCare;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
