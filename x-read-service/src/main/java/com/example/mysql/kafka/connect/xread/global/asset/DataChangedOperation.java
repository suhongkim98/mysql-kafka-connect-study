package com.example.mysql.kafka.connect.xread.global.asset;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DataChangedOperation {

    CREATED('c'),
    UPDATED('u'),
    DELETED('d'),
    ;

    private final char code;

    public static DataChangedOperation from(char code) {
        for (var item : DataChangedOperation.values()) {
            if (item.code == code) {
                return item;
            }
        }

        throw new IllegalArgumentException();
    }
}
