package com.example.mysql.kafka.cnnect.demo.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board_content")
@Getter
@NoArgsConstructor
public class BoardContent {

    @Id
    @Column(name = "board_content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(name = "content")
    private String content;

    public void updateBoard(Board board) {
        this.board = board;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    @Builder
    public BoardContent(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
