package com.hackerrank.github.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.service.IEventService;

/**
 * The Class ResourcesController.
 */
@RestController
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class ResourcesController {
	/** The event service. */
	@Autowired
	private IEventService eventService;
	
	/**
	 * Erase all events.
	 *
	 * @return the response entity
	 */
	@DeleteMapping("/erase")
	public ResponseEntity<Void> eraseAllEvents() {
		eventService.eraseAll();
		return ResponseEntity.ok().build();
	}
}
