package com.example.mysql.kafka.cnnect.demo.board.application.dto;

import com.example.mysql.kafka.cnnect.demo.board.domain.Board;
import lombok.Builder;

import java.util.List;

public record GetBoardsResponse(List<GetBoardDto> list) {

    @Builder
    record GetBoardDto(Long boardId, Long userId, String title) {

    }

    public static GetBoardsResponse from(List<Board> boards) {
        List<GetBoardDto> boardDtoList = boards.stream()
                .map(board -> GetBoardDto.builder()
                        .boardId(board.getId())
                        .title(board.getTitle())
                        .userId(board.getUserId())
                        .build())
                .toList();

        return new GetBoardsResponse(boardDtoList);
    }
}
