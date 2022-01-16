package com.booglejr.marin;

import com.booglejr.marin.repositories.RecurringEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MarinInit implements CommandLineRunner {
 
    @Autowired
    private RecurringEventRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        //repository.save(new RecurringEvent("My Other Show", "Do a thing", DayOfWeek.FRIDAY, LocalTime.of(6, 27)));
    }
}
