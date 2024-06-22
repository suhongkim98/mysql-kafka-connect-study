package com.example.mysql.kafka.connect.xread.board.presentation;

import com.example.mysql.kafka.connect.xread.board.application.BoardService;
import com.example.mysql.kafka.connect.xread.board.application.dto.ConsumedBoardContentDto;
import com.example.mysql.kafka.connect.xread.board.application.dto.ConsumedBoardDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * rdb의 board, boardContent -> readdb mongo의 board 하나로 동기화
 */
@Component
@RequiredArgsConstructor
public class BoardSyncConsumer {

    private final BoardService boardService;
    private final ObjectMapper objectMapper;

    /**
     * RDB Board -> mongo(readdb) Board 동기화
     * 동기화 키: 동기화 키: boardId
     */
    @KafkaListener(topics = "source-mysqldb.demodb.board")
    private void consumeBoardChangeEvent(ConsumerRecord<GenericRecord, GenericRecord> record)  {
        try {
            ConsumedBoardDto boardDto = objectMapper.readValue(String.valueOf(record.value()), new TypeReference<>() {});
            boardService.sync(boardDto);
        } catch (Exception e) {
            // 재처리 프로세스
        }
    }

    /**
     * RDB BoardContent -> mongo(readdb) Board 동기화
     * 동기화 키: boardId
     */
    @KafkaListener(topics = "source-mysqldb.demodb.board_content")
    private void consumeBoardContentChangeEvent(ConsumerRecord<GenericRecord, GenericRecord> record) {
        try {
            ConsumedBoardContentDto boardContentDto = objectMapper.readValue(String.valueOf(record.value()),
                    new TypeReference<>() {});
            boardService.sync(boardContentDto);
        } catch (Exception e) {
            // 재처리 프로세스
        }
    }
}
