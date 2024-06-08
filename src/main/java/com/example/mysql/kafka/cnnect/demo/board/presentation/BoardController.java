package com.example.mysql.kafka.cnnect.demo.board.presentation;

import com.example.mysql.kafka.cnnect.demo.board.application.BoardService;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.CreateBoardRequest;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.GetBoardContentResponse;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.GetBoardsResponse;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.UpdateBoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void createBoard(@RequestHeader("user-id") Long userId, @RequestBody CreateBoardRequest request) {
        boardService.createdBoard(userId, request);
    }

    @PutMapping("/{boardId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateBoard(@RequestHeader("user-id") Long userId, @PathVariable("boardId") Long boardId,
                     @RequestBody UpdateBoardRequest request) {
        boardService.updateBoard(userId, boardId, request);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard(@RequestHeader("user-id") Long userId, @PathVariable("boardId") Long boardId) {
        boardService.deleteBoard(userId, boardId);
    }

    @GetMapping
    public GetBoardsResponse getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/{boardId}/content")
    public GetBoardContentResponse getBoardContent(@PathVariable("boardId") Long boardId) {
        return boardService.getBoardContent(boardId);
    }
}
