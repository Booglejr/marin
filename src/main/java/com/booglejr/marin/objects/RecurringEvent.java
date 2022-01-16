package com.booglejr.marin.objects;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecurringEvent{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String title;
  private String command;
  private DayOfWeek dayOfWeek;
  private LocalTime localTime;
  private LocalTime durTime;

  protected RecurringEvent() {}

  public RecurringEvent(String title, String command, DayOfWeek dayOfWeek, LocalTime localTime, LocalTime durTime) {
    this.title = title;
    this.command = command;
    this.dayOfWeek = dayOfWeek;
    this.localTime = localTime;
    this.durTime = durTime;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, title='%s', command='%s']",
        id, title, command);
  }

  public Long getId() {
    return id;
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