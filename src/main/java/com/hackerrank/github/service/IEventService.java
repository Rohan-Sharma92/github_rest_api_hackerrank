package com.hackerrank.github.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.github.model.Event;

/**
 * The Interface IEventService.
 * @author Rohan
 */
public interface IEventService {

	/**
	 * Creates the event.
	 *
	 * @param event the event
	 * @return true, if successful
	 */
	public boolean createEvent(final Event event);

	/**
	 * Fetch event.
	 *
	 * @param eventId the event id
	 * @return the optional
	 */
	public Optional<Event> fetchEvent(final Long eventId);

	/**
	 * Fetch event by repo.
	 *
	 * @param repoId the repo id
	 * @return the list
	 */
	public List<Event> fetchEventByRepo(final Long repoId);

	/**
	 * Fetch event by actor.
	 *
	 * @param actorId the actor id
	 * @return the list
	 */
	public List<Event> fetchEventByActor(final Long actorId);

	/**
	 * Fetch all event.
	 *
	 * @return the list
	 */
	public List<Event> fetchAllEvent();

	/**
	 * Erase all.
	 */
	public void eraseAll();

	/**
	 * Fetch event by repo and actor.
	 *
	 * @param repoId the repo id
	 * @param actorId the actor id
	 * @return the list
	 */
	public List<Event> fetchEventByRepoAndActor(Long repoId, Long actorId);

}
