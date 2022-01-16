package com.booglejr.marin.controllers;

import com.booglejr.marin.exceptions.EventNotFoundException;
import com.booglejr.marin.objects.OnceEvent;
import com.booglejr.marin.repositories.OnceEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/event/once")
public class OnceEventController {

    @Autowired
    private OnceEventRepository repository;

    @GetMapping("/{id}")
    public OnceEvent findById(@PathVariable long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EventNotFoundException());
    }

    @GetMapping("/")
    public Iterable<OnceEvent> findEvents() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OnceEvent updateEvent(
      @PathVariable("id") final String id, @RequestBody final OnceEvent event) {
        return event;
    }
}