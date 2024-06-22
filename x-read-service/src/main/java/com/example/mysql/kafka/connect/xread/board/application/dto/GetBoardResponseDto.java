package com.example.mysql.kafka.connect.xread.board.application.dto;

import com.example.mysql.kafka.connect.xread.board.domain.Board;
import lombok.Builder;

@Builder
public record GetBoardResponseDto(Long boardId,
                                  Long userId,
                                  Long boardContentId,
                                  String title,
                                  String content) {

    public static GetBoardResponseDto from(Board board) {
        return GetBoardResponseDto.builder()
                .boardId(board.getBoardId())
                .userId(board.getUserId())
                .boardContentId(board.getBoardContentId())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
    }
}
