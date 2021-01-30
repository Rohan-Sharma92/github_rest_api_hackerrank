package com.hackerrank.github.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class EventDTO.
 * @author Rohan
 */
public class EventDTO {
	
	/** The id. */
	private Long id;
	
	/** The type. */
	private String type;
	
	/** The actor. */
	private ActorDTO actor;
	
	/** The repo. */
	private RepoDTO repo;
	
	/** The created at. */
	private Timestamp createdAt;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the actor.
	 *
	 * @return the actor
	 */
	public ActorDTO getActor() {
		return actor;
	}

	/**
	 * Sets the actor.
	 *
	 * @param actor the new actor
	 */
	public void setActor(ActorDTO actor) {
		this.actor = actor;
	}

	/**
	 * Gets the repo.
	 *
	 * @return the repo
	 */
	public RepoDTO getRepo() {
		return repo;
	}

	/**
	 * Sets the repo.
	 *
	 * @param repo the new repo
	 */
	public void setRepo(RepoDTO repo) {
		this.repo = repo;
	}

	/**
	 * Gets the created at.
	 *
	 * @return the created at
	 */
	@JsonProperty("created_at")
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the created at.
	 *
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
