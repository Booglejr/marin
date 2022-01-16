package com.booglejr.marin.repositories;

import com.booglejr.marin.objects.OnceEvent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OnceEventRepository extends JpaRepository<OnceEvent, Long> {

  List<OnceEvent> findByTitle(String title);

  Optional<OnceEvent> findById(long id);
}