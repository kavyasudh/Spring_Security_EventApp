package com.eventapp.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.dao.Event;
import com.eventapp.service.EventService;


@RestController
@RequestMapping("mgr")

public class ManagerController {
	@Autowired
private EventService eService;
	
	
	
	
	public ManagerController(EventService eService) {
		
		this.eService = eService;
	}

	@GetMapping("events")
	public ResponseEntity<List<Event>> getEvent(){
		List<Event> allEvents=eService.getAllEvents();
		return new ResponseEntity<List<Event>>(allEvents,HttpStatus.OK);
	}
	
	@GetMapping("events/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id")int eventId){
		Event eventsById=eService.getEventById(eventId);
		return new ResponseEntity<Event>(eventsById,HttpStatus.OK);
	}
	
	@PostMapping(path="events",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> getEventAdded(@RequestBody Event event){
		eService.addEvent(event);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	
	  @PutMapping(path="events/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Event> getEventUpdated(@PathVariable("id")int eventId,@RequestBody Event event)
	  { 
	   Event eventsUpdated=eService.updateEventDetails(eventId, event); 
	   return new ResponseEntity<Event>(eventsUpdated,HttpStatus.CREATED); 
	  }
	 
	@DeleteMapping(path="events/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> getEventDeleted(@PathVariable("id")int eventId){
		Event eventsDeleted=eService.deleteEventDetails(eventId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	  @GetMapping("eventsN/{name}")
	  public ResponseEntity<Event> getEventByName(@PathVariable("name")String eventName)
	  { 
		  Event eventsByName=eService.findByName(eventName); 
		  return new ResponseEntity<Event>(eventsByName,HttpStatus.OK); 
		  }
	 
}
