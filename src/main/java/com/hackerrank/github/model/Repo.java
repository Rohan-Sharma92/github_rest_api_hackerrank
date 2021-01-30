package com.hackerrank.github.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Repo.
 * 
 * @author Rohan
 */
@Entity
@Table
public class Repo {

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The url. */
	private String url;
	
	/** The events. */
	private List<Event> events;

	/**
	 * Instantiates a new repo.
	 */
	public Repo() {
	}

	/**
	 * Instantiates a new repo.
	 *
	 * @param id   the id
	 * @param name the name
	 * @param url  the url
	 */
	public Repo(Long id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	@Column
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

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
