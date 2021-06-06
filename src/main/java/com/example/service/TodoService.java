package com.example.service;

import com.example.model.TodoEntitiy;
import com.example.model.TodoRequest;
import com.example.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository repo;

    public TodoEntitiy add (TodoRequest request) {
        TodoEntitiy todoEntitiy = new TodoEntitiy();

        todoEntitiy.setTitle(request.getTitle());
        todoEntitiy.setOrder(request.getOrder());
        todoEntitiy.setCompleted(request.getCompleted());

        TodoEntitiy result = this.repo.save(todoEntitiy); // save메소드는 저장된 결과값을 반환한다.

        return result;
    }

    public TodoEntitiy searchById (Long id) {
        TodoEntitiy result = this.repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return result;
    }

    public List<TodoEntitiy> searchAll() {
        return this.repo.findAll();
    }

    public TodoEntitiy updateById(Long id, TodoRequest request) {
        TodoEntitiy entitiy = this.searchById(id);

        if (request.getTitle() != null) {
            entitiy.setTitle(request.getTitle());
        }

        if (request.getOrder() != null) {
            entitiy.setOrder(request.getOrder());
        }

        if (request.getCompleted() != null) {
            entitiy.setCompleted(request.getCompleted());
        }

        return this.repo.save(entitiy);

    }

    public void deleteById (Long id) {
        this.repo.deleteById(id);
    }

    public void deleteByAll () {
        this.repo.deleteAll();
    }
}
