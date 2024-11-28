package com.sourdream.todolistdemo.controller;

import com.sourdream.todolistdemo.TodolistDemoApplication;
import com.sourdream.todolistdemo.bean.Todo;
import com.sourdream.todolistdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/getAllTodo")
    public List<Todo> getAllTodo(){
        return todoService.getAllTodo();
    }

    @PostMapping("/addTodo")
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }



}
