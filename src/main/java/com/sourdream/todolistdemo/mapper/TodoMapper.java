package com.sourdream.todolistdemo.mapper;

import com.sourdream.todolistdemo.bean.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    List<Todo> getAllTodo(); //获取所有todos

    void addTodo(Todo todo);
}
