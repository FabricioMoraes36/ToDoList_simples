package com.TodoListt.TodoList.Service;

import com.TodoListt.TodoList.Entity.Todo;
import com.TodoListt.TodoList.Repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {

    //Injeção de dependencia repository
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //Metodos CRUD

    //Para evitar repetição o metodo create ja chama o metodo list,para listar todas as todo´s
    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    //Consulta ordenada com um objeto do tipo sort que recebe o metodo Sort.by
    public List<Todo>list(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }
    public List<Todo>update(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo>delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
