package com.hackerrank.github.repository;

import java.util.List;

import com.hackerrank.github.model.Event;

public interface ICustomEventRepository {
	public List<Event> findByRepo(Long repoId);

	public List<Event> findByActor(Long actorId);
	
	public List<Event> findByRepoAndActor(Long repoId, Long actorId);
}
