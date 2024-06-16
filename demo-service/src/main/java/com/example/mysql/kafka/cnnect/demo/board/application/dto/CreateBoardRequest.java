package com.example.mysql.kafka.cnnect.demo.board.application.dto;

import lombok.Builder;

@Builder
public record CreateBoardRequest(String title, String content) {
}
