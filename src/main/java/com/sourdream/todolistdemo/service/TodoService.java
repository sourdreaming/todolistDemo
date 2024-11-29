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

    public Todo getTodoById(Long id) {
        if (id == null && id <= 0) {
            return null;
        }
        return todoMapper.getTodoById(id);
    }


    public String deleteTodo(Long id) {
        if (id == null && id <= 0) {
           return "Invalid ID";
        }
       Long rowsAffected = todoMapper.deleteTodo(id);
        if (rowsAffected > 0) {
            return "Success";
        } else {
            return "Todo not found";
        }
    }


//    //更新 todo 的 content 和 status
//    public String updateContentTodoById(Long id, Todo todo) {
//       //判断 id 是否合法
//        if (id == null || id <= 0) {
//            return "Invalid ID";
//        }
//       // id 合法后，查询对应的 todo，将 todo 中的 content 修改为新的 content
//        Todo existingTodo = todoMapper.getTodoById(id);
//        if (existingTodo == null) {
//            return "Todo not found";
//        }
//
//        existingTodo.setContent(todo.getContent());
//
//        Long rowsAffected = todoMapper.updateContentTodoById(existingTodo);
//        if (rowsAffected != 0) {
//            return "Failure";
//        }
//        return "Success";
//
//    }

    public String updateStatusTodoById(Long id, Todo todo){
        // 调用 mapper 中的方法更新 todo 的 status
        if (id == null && id <= 0){
            return "Invalid ID";
        }
        if (todo.getStatus())
    }

}
