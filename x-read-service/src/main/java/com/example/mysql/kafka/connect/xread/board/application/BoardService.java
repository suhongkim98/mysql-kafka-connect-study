package com.example.mysql.kafka.connect.xread.board.application;

import com.example.mysql.kafka.connect.xread.board.application.dto.ConsumedBoardContentDto;
import com.example.mysql.kafka.connect.xread.board.application.dto.ConsumedBoardDto;
import com.example.mysql.kafka.connect.xread.board.application.dto.GetBoardResponseDto;
import com.example.mysql.kafka.connect.xread.board.domain.BoardRepository;
import com.example.mysql.kafka.connect.xread.global.asset.DataChangedOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void sync(ConsumedBoardDto consumedBoardDto) {
        DataChangedOperation operation = DataChangedOperation.from(consumedBoardDto.op());
        switch (operation) {
            case CREATED, UPDATED -> {
                Long boardId = boardRepository.upsertBoard(consumedBoardDto.boardId(), consumedBoardDto.userId(),
                        consumedBoardDto.title());

                log.info(boardId + " board created or updated");
            }
            case DELETED -> {
                boardRepository.deleteById(consumedBoardDto.boardId());
                log.info(consumedBoardDto.boardId() + " board deleted");
            }
        }
    }

    public void sync(ConsumedBoardContentDto consumedBoardContentDto) {
        DataChangedOperation operation = DataChangedOperation.from(consumedBoardContentDto.op());
        switch (operation) {
            case CREATED, UPDATED -> {
                boardRepository.updateBoardContent(consumedBoardContentDto.boardId(),
                        consumedBoardContentDto.boardContentId(), consumedBoardContentDto.content(), true);
                log.info("board content created or updated");
            }
            case DELETED -> {
                boardRepository.updateBoardContent(consumedBoardContentDto.boardId(), null, null,
                        false);
                log.info("board content deleted");
            }
        }
    }

    /**
     * Mongo에 동기화된 Board 를 반환
     */
    public GetBoardResponseDto getBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .map(GetBoardResponseDto::from)
                .orElseThrow(() -> new RuntimeException("not found board"));
    }
}
