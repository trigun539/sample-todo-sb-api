package io.eperez.todosp.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.eperez.todosp.models.Todo;
import io.eperez.todosp.repositories.TodoRepository;

@RestController
@RequestMapping("api/v1")
public class TodoController {

  @Autowired
  private TodoRepository todoRepository;

  @RequestMapping(value = "todos", method = RequestMethod.GET)
  public List<Todo> list() {
    return todoRepository.findAll();
  }

  @RequestMapping(value = "todos", method = RequestMethod.POST)
  public Todo create(@RequestBody Todo todo) {
    return todoRepository.saveAndFlush(todo);
  }

  @RequestMapping(value = "todos/{id}", method = RequestMethod.GET)
  public Todo get(@PathVariable Long id) {
    return todoRepository.getOne(id);
  }

  @RequestMapping(value = "todos/{id}", method = RequestMethod.PUT)
  public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
    Todo oldTodo = todoRepository.getOne(id);
    BeanUtils.copyProperties(todo, oldTodo);
    return todoRepository.saveAndFlush(oldTodo);
  }

  @RequestMapping(value = "todos/{id}", method = RequestMethod.DELETE)
  public Todo delete(@PathVariable Long id) {
    Todo oldTodo = todoRepository.getOne(id);
    todoRepository.delete(oldTodo);
    return oldTodo;
  }

}
