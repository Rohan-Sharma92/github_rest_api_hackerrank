package com.hackerrank.github.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.dto.EventDTO;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.IEventService;

/**
 * The Class EventsController.
 */
@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class EventsController {

	/** The event service. */
	@Autowired
	private IEventService eventService;

	/** The mapper. */
	@Autowired
	private ModelMapper mapper;

	/**
	 * Save event.
	 *
	 * @param eventDTO the event DTO
	 * @return the response entity
	 */
	@PostMapping(path = "/events", consumes = APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> saveEvent(@RequestBody EventDTO eventDTO) {
		try {
			Event event = mapper.map(eventDTO, Event.class);
			boolean isSuccess = eventService.createEvent(event);
			if (isSuccess)
				return ResponseEntity.status(HttpStatus.CREATED).build();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (MappingException | ConfigurationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Gets the events.
	 *
	 * @return the events
	 */
	@GetMapping("/events")
	public ResponseEntity<List<EventDTO>> getEvents() {
		Iterable<Event> iterable = eventService.fetchAllEvent();
		List<EventDTO> events = new ArrayList<>();
		iterable.forEach(event -> events.add(mapper.map(event, EventDTO.class)));
		return ResponseEntity.ok().body(events);
	}

	/**
	 * Gets the events by actor id.
	 *
	 * @param actorId the actor id
	 * @return the events by actor id
	 */
	@GetMapping("/events/actors/{id}")
	public ResponseEntity<List<EventDTO>> getEventsByActorId(@PathVariable("id") Long actorId) {
		List<Event> events = eventService.fetchEventByActor(actorId);
		List<EventDTO> eventsDTO = events.stream().map(e -> mapper.map(e, EventDTO.class)).collect(Collectors.toList());
		if(events.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(eventsDTO);
	}

	/**
	 * Gets the events by id.
	 *
	 * @param eventId the event id
	 * @return the events by id
	 */
	@GetMapping("/events/{id}")
	public ResponseEntity<EventDTO> getEventsById(@PathVariable("id") Long eventId) {
		Optional<Event> event = eventService.fetchEvent(eventId);
		if (!event.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(mapper.map(event.get(), EventDTO.class));
	}

	/**
	 * Gets the events by repo id.
	 *
	 * @param repoId the repo id
	 * @return the events by repo id
	 */
	@GetMapping("/events/repos/{id}")
	public ResponseEntity<List<EventDTO>> getEventsByRepoId(@PathVariable("id") Long repoId) {
		List<Event> events = eventService.fetchEventByRepo(repoId);
		if(events.isEmpty())
			return ResponseEntity.notFound().build();
		List<EventDTO> eventsDTO = events.stream().map(e -> mapper.map(e, EventDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(eventsDTO);
	}
	
	@GetMapping("/events/repos/{id}/actors/{actorId}")
	public ResponseEntity<List<EventDTO>> getEventsByRepoAndActorId(@PathVariable("id") Long repoId,@PathVariable("actorId") Long actorId) {
		List<Event> events = eventService.fetchEventByRepoAndActor(repoId,actorId);
		if(events.isEmpty())
			return ResponseEntity.notFound().build();
		List<EventDTO> eventsDTO = events.stream().map(e -> mapper.map(e, EventDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(eventsDTO);
	}

}
