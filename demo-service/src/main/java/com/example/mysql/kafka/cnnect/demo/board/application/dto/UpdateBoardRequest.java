package com.example.mysql.kafka.cnnect.demo.board.application.dto;

import lombok.Builder;

@Builder
public record UpdateBoardRequest(String title, String content) {
}
