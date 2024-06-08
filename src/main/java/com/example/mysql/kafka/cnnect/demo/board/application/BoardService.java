package com.example.mysql.kafka.cnnect.demo.board.application;

import com.example.mysql.kafka.cnnect.demo.board.application.dto.CreateBoardRequest;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.GetBoardContentResponse;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.GetBoardsResponse;
import com.example.mysql.kafka.cnnect.demo.board.application.dto.UpdateBoardRequest;
import com.example.mysql.kafka.cnnect.demo.board.domain.Board;
import com.example.mysql.kafka.cnnect.demo.board.domain.BoardContent;
import com.example.mysql.kafka.cnnect.demo.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    public void createdBoard(Long userId, CreateBoardRequest request) {
        BoardContent boardContent = BoardContent.builder()
                .content(request.content())
                .build();

        Board board = Board.builder()
                .userId(userId)
                .title(request.title())
                .boardContent(boardContent)
                .build();

        boardRepository.save(board);
    }

    public void updateBoard(Long userId, Long boardId, UpdateBoardRequest request) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("not found board"));
        log.info(String.format("%s update board %s ^_^", userId, board.getId()));

        board.update(request.title(), request.content());
    }

    public void deleteBoard(Long userId, Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("not found board"));
        log.info(String.format("%s delete board %s ^_^", userId, board.getId()));

        boardRepository.delete(board);
    }

    public void deleteAllBoards() {
        boardRepository.deleteAll();
    }

    public GetBoardsResponse getBoards() {
        List<Board> boards = boardRepository.findAll();
        return GetBoardsResponse.from(boards);
    }

    public GetBoardContentResponse getBoardContent(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("not found board"));

        return GetBoardContentResponse.from(board);
    }
}
