package com.example.todoapp.controllers;

import com.example.todoapp.dto.TodoRequestDto;
import com.example.todoapp.dto.TodoResponseDto;
import com.example.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("save-todo")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDto saveTodo(@RequestBody TodoRequestDto todoRequestDto){
        return todoService.createTodo(todoRequestDto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResponseDto> getAllTodoForCurrentUser(){
        return todoService.getAllTodoForCurrentUser();
    }

    @GetMapping("{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDto getTodoById(@PathVariable Long todoId) {
        return todoService.getTodoById(todoId);
    }

    @PutMapping("{todoId}")
    @ResponseStatus(HttpStatus.OK)
    public TodoResponseDto updateTodo(@PathVariable Long todoId, @RequestBody TodoRequestDto updatedTodo) {
        return todoService.updateTodoForCurrentUser(todoId, updatedTodo);
    }

    @DeleteMapping("{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodoForCurrentUser(todoId);
    }
}
