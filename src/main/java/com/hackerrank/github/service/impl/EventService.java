package com.hackerrank.github.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.service.IEventService;

@Service
public class EventService implements IEventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public boolean createEvent(Event event) {
		if(eventRepository.existsById(event.getId()))
			return false;
		eventRepository.save(event);
		return true;
	}

	@Override
	public Optional<Event> fetchEvent(Long eventId) {
		return eventRepository.findById(eventId);
	}

	@Override
	public List<Event> fetchEventByRepo(Long repoId) {
		return eventRepository.findByRepo(repoId);
	}

	@Override
	public List<Event> fetchEventByActor(Long actorId) {
		return eventRepository.findByActor(actorId);
	}

	@Override
	public List<Event> fetchAllEvent() {
		return eventRepository.findAll(Sort.by(Direction.ASC,"id"));
	}

	@Override
	public void eraseAll() {
		eventRepository.deleteAll();
	}

	@Override
	public List<Event> fetchEventByRepoAndActor(Long repoId,Long actorId) {
		return eventRepository.findByRepoAndActor(repoId,actorId);
	}

}
