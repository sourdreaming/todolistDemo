show tables;

use demo;


CREATE TABLE todo (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 自增主键
                      content VARCHAR(255) NOT NULL,         -- Todo 的内容
                      status VARCHAR(20) NOT NULL            -- Todo 的状态，状态值为 "todo" 或 "done"
);


INSERT INTO todo (content, status) VALUES
                                       ('Finish homework', 'todo'),
                                       ('Read a book', 'done'),
                                       ('Go for a walk', 'todo'),
                                       ('Buy groceries', 'done'),
                                       ('Clean the house', 'todo');
