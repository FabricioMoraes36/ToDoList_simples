package com.TodoListt.TodoList.Controller;

import com.TodoListt.TodoList.Entity.Todo;
import com.TodoListt.TodoList.Service.TodoService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //POST
    @PostMapping("/create")
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }
    //GET
    @GetMapping("/list-all")
    List<Todo>list(){
        return todoService.list();
    }

    //PUT
    @PutMapping("/update")
    List<Todo>update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    List<Todo>delete(@PathVariable Long id){
        return todoService.delete(id);
    }

}
