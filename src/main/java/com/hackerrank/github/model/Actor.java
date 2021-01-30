package com.hackerrank.github.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Actor.
 * @author Rohan
 */
@Entity
@Table
public class Actor {
	
	/** The id. */
	private Long id;
	
	/** The login. */
	private String login;
	
	/** The avatar. */
	private String avatar;
	
	/** The events. */
	private List<Event> events;

	/**
	 * Instantiates a new actor.
	 */
	public Actor() {
	}

	/**
	 * Instantiates a new actor.
	 *
	 * @param id the id
	 * @param login the login
	 * @param avatar the avatar
	 */
	public Actor(Long id, String login, String avatar) {
		this.id = id;
		this.login = login;
		this.avatar = avatar;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Column
	@Id
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	@Column
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the avatar.
	 *
	 * @return the avatar
	 */
	@Column
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Sets the avatar.
	 *
	 * @param avatar the new avatar
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "actor")
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * Sets the events.
	 *
	 * @param events the new events
	 */
	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
