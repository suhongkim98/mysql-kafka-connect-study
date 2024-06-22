package com.example.mysql.kafka.connect.xread.board.presentation;

import com.example.mysql.kafka.connect.xread.board.application.BoardService;
import com.example.mysql.kafka.connect.xread.board.application.dto.GetBoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public GetBoardResponseDto getBoard(@PathVariable("boardId") Long boardId) {
        return boardService.getBoard(boardId);
    }
}
