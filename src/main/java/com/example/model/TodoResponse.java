package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
    private String url;

    public TodoResponse(TodoEntitiy todoEntitiy) {
        this.id = todoEntitiy.getId();
        this.title = todoEntitiy.getTitle();
        this.order = todoEntitiy.getOrder();
        this.completed = todoEntitiy.getCompleted();

        this.url = "http://localhost:8080/" + this.id;
    }
}
