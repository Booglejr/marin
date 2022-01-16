package com.booglejr.marin.repositories;

import com.booglejr.marin.objects.RecurringEvent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringEventRepository extends JpaRepository<RecurringEvent, Long> {

  List<RecurringEvent> findByTitle(String title);

  Optional<RecurringEvent> findById(long id);
}