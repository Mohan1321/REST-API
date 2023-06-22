package com.todoApp.todolistApp.TodoRepo;

import com.todoApp.todolistApp.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo,Long> {
}
