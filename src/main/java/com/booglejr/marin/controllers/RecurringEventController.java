package com.booglejr.marin.controllers;

import javax.validation.Valid;
import javax.validation.constraints.Null;

import com.booglejr.marin.dto.RecurringEventDto;
import com.booglejr.marin.exceptions.EventNotFoundException;
import com.booglejr.marin.objects.RecurringEvent;
import com.booglejr.marin.services.RecurringEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/event/recurring")
public class RecurringEventController {

    @Autowired
	private RecurringEventService service;
	

    @GetMapping("/")
    public Iterable<RecurringEvent> findEvents() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecurringEventDto> findById(@PathVariable long id) {
        RecurringEvent event = service.findById(id)
            .orElseThrow(() -> new EventNotFoundException());
        
        RecurringEventDto eventResponse = new RecurringEventDto();
        eventResponse.setId(event.getId());
        eventResponse.setCommand(event.getCommand());
        eventResponse.setDayOfWeek(event.getDayOfWeek());
        eventResponse.setLocalTime(event.getLocalTime());
        eventResponse.setDurTime(event.getLocalTime());

        return new ResponseEntity<RecurringEventDto>(eventResponse, HttpStatus.OK);
    }

	@PostMapping()
	public ResponseEntity<RecurringEventDto> createRecurringEvent(@Valid @RequestBody RecurringEventDto eventDto){
	
		// convert RecurringEventDto to RecurringEvent entity
		RecurringEvent event = new RecurringEvent(
            eventDto.getTitle(),
            eventDto.getCommand(),
            eventDto.getDayOfWeek(),
            eventDto.getLocalTime(),
            eventDto.getDurTime()
        );

		RecurringEvent savedEvent = service.createRecurringEvent(event);
		
		// convert RecurringEvent entity to RecurringEventDto class
		RecurringEventDto eventResponse = new RecurringEventDto();
		eventResponse.setId(savedEvent.getId());
		eventResponse.setCommand(savedEvent.getCommand());
		eventResponse.setDayOfWeek(savedEvent.getDayOfWeek());
        eventResponse.setLocalTime(savedEvent.getLocalTime());
        eventResponse.setDurTime(savedEvent.getLocalTime());
		
		return new ResponseEntity<RecurringEventDto>(eventResponse, HttpStatus.CREATED);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<Null> deleteById(@PathVariable long id) {
        service.deleteById(id)
            .orElseThrow(() -> new EventNotFoundException());

        return new ResponseEntity<Null>(HttpStatus.NO_CONTENT);
    }
}