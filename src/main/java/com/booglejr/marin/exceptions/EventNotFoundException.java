package com.booglejr.marin.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventNotFoundException extends EntityNotFoundException {
    
}
