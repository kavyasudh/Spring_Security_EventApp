package com.eventapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.eventapp.dao.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer>{
	
	public Event findByEventName(String eventName);

}
