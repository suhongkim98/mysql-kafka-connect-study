package com.example.mysql.kafka.connect.xread.board.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ConsumedBoardContentDto(@JsonProperty("board_content_id") Long boardContentId,
                                      @JsonProperty("board_id") Long boardId,
                                      @JsonProperty("content") String content,
                                      @JsonProperty("__op") char op,
                                      @JsonProperty("__deleted") boolean deleted) {
}
