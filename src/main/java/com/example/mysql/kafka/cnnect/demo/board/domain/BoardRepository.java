package com.example.mysql.kafka.cnnect.demo.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
