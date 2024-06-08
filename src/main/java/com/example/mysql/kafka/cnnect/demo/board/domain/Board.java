package com.example.mysql.kafka.cnnect.demo.board.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "board", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private BoardContent boardContent;

    @Builder
    public Board(Long id, Long userId, String title, BoardContent boardContent) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.boardContent = boardContent;
        this.boardContent.updateBoard(this);
    }

    public void update(String title, String content) {
        this.title = title;
        this.boardContent.updateContent(content);
    }
}