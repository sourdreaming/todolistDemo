package com.sourdream.todolistdemo.controller;

import com.sourdream.todolistdemo.bean.Todo;
import com.sourdream.todolistdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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



    @PostMapping("/deleteTodo/{id}")
    public ResponseEntity<String> deleteTodoById(@PathVariable Long id) {
        String result = todoService.deleteTodo(id);
        if ("Success".equals(result)){
            return ResponseEntity.ok("Todo deleted Success");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }


//    @PostMapping("/updateContentTodo/{id}")
//    //获取前端传入的 id 和 todo，调用 service 中的 updateContentTodoById 方法，返回更新结果
//    public ResponseEntity<String> updateContentTodo(@PathVariable Long id, @RequestBody Todo todo) {
//        String result = todoService.updateContentTodoById(id, todo);
//        if ("Success".equals(result)){
//            return ResponseEntity.ok("Todo updated Success");
//        }else{
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
//        }
//    }



    //更新 todo 的 status，根据 todo 的 id

    @PostMapping("/updateStatusTodo/{id}")
    public ResponseEntity<String> updateStatusTodo(@PathVariable Long id, @RequestBody Todo todo){
        // 调用 service 中的 updateStatusTodoById 方法，返回更新结果
        String result = todoService.updateStatusTodoById(id,todo);
        if ("Success".equals(result)){
            return ResponseEntity.ok("Status updated Success");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

    }

}
