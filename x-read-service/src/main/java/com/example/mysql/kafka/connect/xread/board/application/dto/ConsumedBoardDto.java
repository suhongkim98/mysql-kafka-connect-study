package com.example.mysql.kafka.connect.xread.board.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConsumedBoardDto(@JsonProperty("board_id") Long boardId,
                               @JsonProperty("user_id") Long userId,
                               @JsonProperty("title") String title,
                               @JsonProperty("__op") char op,
                               @JsonProperty("__deleted") boolean deleted) {
}
