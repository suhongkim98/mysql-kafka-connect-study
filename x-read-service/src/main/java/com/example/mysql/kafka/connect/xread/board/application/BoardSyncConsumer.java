package com.example.mysql.kafka.connect.xread.board.application;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * rdb의 board, boardContent -> readdb mongo의 board 하나로 동기화
 */
@Component
public class BoardSyncConsumer {

    /**
     * RDB Board -> mongo(readdb) Board 동기화
     * 동기화 키: 동기화 키: boardId
     */
    @KafkaListener(topics = "source-mysqldb.demodb.board")
    private void consumeBoardChangeEvent(ConsumerRecord<GenericRecord, GenericRecord> record) {
        System.out.println(record.value());
        System.out.println(record.key());
    }

    /**
     * RDB BoardContent -> mongo(readdb) Board 동기화
     * 동기화 키: boardId
     */
    @KafkaListener(topics = "source-mysqldb.demodb.board_content")
    private void consumeBoardContentChangeEvent(ConsumerRecord<GenericRecord, GenericRecord> record) {
        System.out.println(record.value());
        System.out.println(record.key());
    }
}
