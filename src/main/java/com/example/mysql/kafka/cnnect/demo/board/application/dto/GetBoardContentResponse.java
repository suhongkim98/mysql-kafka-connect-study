package com.example.mysql.kafka.cnnect.demo.board.application.dto;

import com.example.mysql.kafka.cnnect.demo.board.domain.Board;

public record GetBoardContentResponse(String content) {

    public static GetBoardContentResponse from(Board board) {
        return new GetBoardContentResponse(board.getBoardContent().getContent());
    }
}
