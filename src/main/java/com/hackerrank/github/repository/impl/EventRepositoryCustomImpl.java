package com.hackerrank.github.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ICustomEventRepository;

public class EventRepositoryCustomImpl implements ICustomEventRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Event> findByRepo(Long repoId) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Event.class);
		criteria.add(Restrictions.eq("repo.id",repoId));
		List<Event> result = criteria.list();
		return result;
	}

	@Override
	public List<Event> findByActor(Long actorId) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Event.class);
		criteria.add(Restrictions.eq("actor.id",actorId));
		List<Event> result = criteria.list();
		return result;
	}

	@Override
	public List<Event> findByRepoAndActor(Long repoId, Long actorId) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Event.class);
		criteria.add(Restrictions.eq("repo.id",repoId));
		criteria.add(Restrictions.eq("actor.id",actorId));
		List<Event> result = criteria.list();
		return result;
	}

}
