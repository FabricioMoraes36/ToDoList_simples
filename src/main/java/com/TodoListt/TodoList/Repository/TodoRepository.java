package com.TodoListt.TodoList.Repository;


import com.TodoListt.TodoList.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
