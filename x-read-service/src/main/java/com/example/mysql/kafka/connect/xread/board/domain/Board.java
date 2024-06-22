package com.example.mysql.kafka.connect.xread.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document
public class Board {

    @Id
    private Long boardId;
    private Long userId;
    private Long boardContentId;
    private String title;
    private String content;
}
