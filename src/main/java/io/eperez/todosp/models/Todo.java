package io.eperez.todosp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo  {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String text;
  Boolean done;

  public Todo () { }

  public Todo (Long id, String text, Boolean done) {
    this.id = id;
    this.text = text;
    this.done = done;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return text;
  }

  public void setName(String text) {
    this.text = text;
  }

  public Boolean getDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }
}
