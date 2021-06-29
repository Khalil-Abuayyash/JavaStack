package com.example.eventsBeltReviwer.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@Email(message="Email must be valid")
	private String email;
	
	@NotNull
	private String location;
	
	private String state;
	
	private String password;
	
	@Transient
    private String passwordConfirmation;
	
	@OneToMany(mappedBy="coordinator", fetch = FetchType.LAZY)
	private List<Event> coordinatedEvents;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "events_users",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="event_id")
	)
	private List<Event> attendedEvents;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	
	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public User() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public List<Event> getCoordinatedEvents() {
		return coordinatedEvents;
	}


	public void setCoordinatedEvents(List<Event> coordinatedEvents) {
		this.coordinatedEvents = coordinatedEvents;
	}


	public List<Event> getAttendedEvents() {
		return attendedEvents;
	}


	public void setAttendedEvents(List<Event> attendedEvents) {
		this.attendedEvents = attendedEvents;
	} 
	
	
}
