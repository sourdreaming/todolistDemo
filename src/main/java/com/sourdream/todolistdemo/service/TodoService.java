package com.sourdream.todolistdemo.service;

import com.sourdream.todolistdemo.bean.Todo;
import com.sourdream.todolistdemo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoMapper todoMapper;

    public List<Todo> getAllTodo() {
        return todoMapper.getAllTodo();
    }

    public void addTodo(Todo todo) {
        if (todo.getContent() == null || todo.getContent().isEmpty()){
            throw new IllegalArgumentException("Content cannot be empty");
        }
        // Bug 修复：将 || 改为 &&，并添加了括号来明确运算顺序
        if (("todo".equals(todo.getStatus())) || ("done".equals(todo.getStatus()))){
            todoMapper.addTodo(todo);
        } else {
            // 在这里处理 status 不合法的情况
            throw new IllegalArgumentException("Invalid status" );
        }
    }
}
