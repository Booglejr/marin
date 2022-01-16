package com.booglejr.marin.objects;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnceEvent{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String title;
  private String command;
  private LocalDateTime dateTime;

  protected OnceEvent() {}

  public OnceEvent(String title, String command, LocalDateTime dateTime) {
    this.title = title;
    this.command = command;
    this.dateTime = dateTime;
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

  public LocalDateTime getDateTime() {
      return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
      this.dateTime = dateTime;
  }
}