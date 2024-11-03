package com.example.todoapp.service;

import com.example.todoapp.dto.TodoRequestDto;
import com.example.todoapp.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {
    public List<TodoResponseDto> getAllTodoForCurrentUser();
    public TodoResponseDto getTodoById(Long todoId);
    public TodoResponseDto updateTodoForCurrentUser(Long todoId,TodoRequestDto requestDto);
    public void deleteTodoForCurrentUser(Long todoId);
    public TodoResponseDto createTodo(TodoRequestDto requestDto);
}
