package com.example.todoapp.serviceImpl;

import com.example.todoapp.dto.TodoRequestDto;
import com.example.todoapp.dto.TodoResponseDto;
import com.example.todoapp.entities.Todo;
import com.example.todoapp.entities.User;
import com.example.todoapp.repositories.TodoRepository;
import com.example.todoapp.repositories.UserRepository;
import com.example.todoapp.service.TodoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TodoResponseDto> getAllTodoForCurrentUser() {
        List<TodoResponseDto> todoResponseDtos = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username);
        List<Todo> todoList =  user.getTodos();
        for(Todo todo:todoList){
            TodoResponseDto responseDto = modelMapper.map(todo,TodoResponseDto.class);
            todoResponseDtos.add(responseDto);
        }
        return todoResponseDtos;
    }

    @Override
    public TodoResponseDto getTodoById(Long todoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username);

        Todo todo = todoRepository.findByIdAndUser(todoId,user);
        return modelMapper.map(todo,TodoResponseDto.class);
    }

    @Override
    public TodoResponseDto updateTodoForCurrentUser(Long todoId, TodoRequestDto requestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username);

        Todo existingTodo = todoRepository.findByIdAndUser(todoId,user);
        existingTodo.setTitle(requestDto.getTitle());
        existingTodo.setDescription(requestDto.getDescription());
        Todo updatedTodo = todoRepository.save(existingTodo);
        return modelMapper.map(updatedTodo,TodoResponseDto.class);
    }

    @Override
    public void deleteTodoForCurrentUser(Long todoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username);

        Todo existingTodo = todoRepository.findByIdAndUser(todoId,user);
        todoRepository.delete(existingTodo);
    }

    @Override
    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = modelMapper.map(requestDto, Todo.class);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username);

        todo.setUser(user);
        Todo savedTodo = todoRepository.save(todo);
        return modelMapper.map(savedTodo,TodoResponseDto.class);
    }
}
