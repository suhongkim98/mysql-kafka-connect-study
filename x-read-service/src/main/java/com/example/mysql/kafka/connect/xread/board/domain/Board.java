package com.example.mysql.kafka.connect.xread.board.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Board {

    private Long id;
    private Long userId;
    private Long boardContentId;
    private String title;
    private String content;
}
