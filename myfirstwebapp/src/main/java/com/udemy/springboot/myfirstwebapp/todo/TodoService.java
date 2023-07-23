package com.udemy.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn Spring boot 1", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn AWS 1", LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(++todosCount, "in28minutes", "Learn DevOps 1", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predeicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todoList.stream().filter(predeicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todoList.add(todo);
    }

    public void deleteTodo(int id) {
//        todo.getId() == id
//        todo -> todo.getId() == id
        Predicate<? super Todo> predeicate = todo -> todo.getId() == id;
        todoList.removeIf(predeicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predeicate = todo -> todo.getId() == id;
        Todo todo = todoList.stream().filter(predeicate).findFirst().get();
        return todo;
    }


    public void updateTodo(Todo todo) {
        deleteTodo((int) todo.getId());
        todoList.add(todo);
    }
}
