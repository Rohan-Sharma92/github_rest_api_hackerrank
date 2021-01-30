package com.hackerrank.github.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Event.
 * @author Rohan
 */
@Entity
@Table
public class Event {
    
    /** The id. */
    private Long id;
    
    /** The type. */
    private String type;
    
    /** The actor. */
    private Actor actor;
    
    /** The repo. */
    private Repo repo;
    
    /** The created at. */
    private Timestamp createdAt;

    /**
     * Instantiates a new event.
     */
    public Event() {
    }

    /**
     * Instantiates a new event.
     *
     * @param id the id
     * @param type the type
     * @param actor the actor
     * @param repo the repo
     * @param createdAt the created at
     */
    public Event(Long id, String type, Actor actor, Repo repo, Timestamp createdAt) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.createdAt = createdAt;
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
     * Gets the type.
     *
     * @return the type
     */
    @Column
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Actor getActor() {
        return actor;
    }

    /**
     * Sets the actor.
     *
     * @param actor the new actor
     */
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    /**
     * Gets the repo.
     *
     * @return the repo
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Repo getRepo() {
        return repo;
    }

    /**
     * Sets the repo.
     *
     * @param repo the new repo
     */
    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    /**
     * Gets the created at.
     *
     * @return the created at
     */
    @Column
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
