package com.example.todoapp.repositories;

import com.example.todoapp.entities.Todo;
import com.example.todoapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    Todo findByIdAndUser(Long todoId, User user);
}
