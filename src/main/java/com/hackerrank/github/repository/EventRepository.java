package com.hackerrank.github.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Event;

/**
 * The Interface EventRepository.
 * 
 * @author Rohan
 */
public interface EventRepository extends JpaRepository<Event, Long>, ICustomEventRepository {

}
