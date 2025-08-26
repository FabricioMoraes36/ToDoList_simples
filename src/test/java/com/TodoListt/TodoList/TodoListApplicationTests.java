package com.TodoListt.TodoList;

import com.TodoListt.TodoList.Entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListApplicationTests {

    @Autowired
    private WebTestClient  webTestClient;

    @Test
    void testCreateTodoSuccess(){
        var todo1 = new Todo("Teste", "Descricao opcional", false, 1);
        webTestClient.post()
                .uri("/Todos/create")
                .bodyValue(todo1)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo1.getName())
                .jsonPath("$[0].description").isEqualTo(todo1.getDescription())
                .jsonPath("$[0].status").isEqualTo(todo1.isStatus())
                .jsonPath("$[0].priority").isEqualTo(todo1.getPriority());
    }
    @Test
    void testCreateTodoFail(){
        webTestClient
                .post()
                .uri("/Todos/create")
                .bodyValue(new Todo("","",false,0))
                .exchange()
                .expectStatus().isBadRequest();

    }
}
