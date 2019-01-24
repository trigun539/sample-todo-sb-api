package io.eperez.todosp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import io.eperez.todosp.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {}
