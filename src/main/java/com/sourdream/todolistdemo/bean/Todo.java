package com.sourdream.todolistdemo.bean;

import lombok.Data;

@Data
public class Todo {
    private Long id;// 自增主键
    private String content; //todo 的内容
    private String status; // todo 的状态，是否完成 todo，done
}
