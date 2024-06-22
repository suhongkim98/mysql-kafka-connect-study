package com.example.mysql.kafka.connect.xread.board.infrastructure.repository;

import com.example.mysql.kafka.connect.xread.board.domain.Board;
import com.example.mysql.kafka.connect.xread.board.domain.BoardCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public Long upsertBoard(Long boardId, Long userId, String title) {
        Query query = new Query(Criteria.where("boardId").is(boardId));
        Update update = new Update();
        update.set("userId", userId);
        update.set("title", title);

        mongoTemplate.upsert(query, update, Board.class);
        return boardId;
    }

    @Override
    public void updateBoardContent(Long boardId, Long boardContentId, String content, boolean isUpsert) {
        Query query = new Query(Criteria.where("boardId").is(boardId));
        Update update = new Update();
        update.set("boardContentId", boardContentId);
        update.set("content", content);

        if (isUpsert) {
            mongoTemplate.upsert(query, update, Board.class);
        } else {
            mongoTemplate.updateFirst(query, update, Board.class);
        }
    }
}
