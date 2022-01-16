package com.booglejr.marin.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;

public class RecurringEventDto {
	
    private long id;
    
    private String title;
    
    private String command;
    
    @NotEmpty
    private DayOfWeek dayOfWeek;

    @NotEmpty
    private LocalTime localTime;

    @NotEmpty
    private LocalTime durTime;
	

    public RecurringEventDto() {}

    public RecurringEventDto(String title, String command, DayOfWeek dayOfWeek, LocalTime localTime, LocalTime durTime) {
      this.title = title;
      this.command = command;
      this.dayOfWeek = dayOfWeek;
      this.localTime = localTime;
      this.durTime = durTime;
    }


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalTime getDurTime() {
        return durTime;
    }

    public void setDurTime(LocalTime durTime) {
        this.durTime = durTime;
    }
}
