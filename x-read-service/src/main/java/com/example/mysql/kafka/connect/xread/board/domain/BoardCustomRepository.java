package com.example.mysql.kafka.connect.xread.board.domain;

public interface BoardCustomRepository {

    Long upsertBoard(Long boardId, Long userId, String title);

    void updateBoardContent(Long boardId, Long boardContentId, String content, boolean isUpsert);
}
