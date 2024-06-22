package com.example.mysql.kafka.connect.xread.board.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board, Long>, BoardCustomRepository {

}
