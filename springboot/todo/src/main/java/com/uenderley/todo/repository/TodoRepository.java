package com.uenderley.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uenderley.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
