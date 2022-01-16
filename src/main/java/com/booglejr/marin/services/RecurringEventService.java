package com.booglejr.marin.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.booglejr.marin.objects.RecurringEvent;
import com.booglejr.marin.repositories.RecurringEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecurringEventService {

	@Autowired
	private RecurringEventRepository repository;
	
	public RecurringEvent createRecurringEvent(RecurringEvent event) {
		return repository.save(event);
	}

    public Optional<RecurringEvent> findById(Long id) {
        return repository.findById(id);
    }

    public Iterable<RecurringEvent> findAll() {
        return repository.findAll();
    }

    public Optional<Boolean> deleteById(Long id){
        try {
            repository.deleteById(id);
            return Optional.of(true);
        } catch (EntityNotFoundException e) {
            return Optional.empty();
        }
    }
}
