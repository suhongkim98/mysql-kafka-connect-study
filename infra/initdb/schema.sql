create database demodb default character set utf8 collate utf8_general_ci;

CREATE TABLE demodb.board (
    board_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    title VARCHAR(128) NOT NULL
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE demodb.board_content (
    board_content_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    board_id BIGINT NOT NULL,
    content TEXT NOT NULL,
    UNIQUE KEY tci_board_content_UX_board_id(board_id)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
