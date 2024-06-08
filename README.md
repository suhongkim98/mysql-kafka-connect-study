# mysql-kafka-connect-study
가볍게 `mysql` source connector 학습하기

# 기술스택
* `spring boot`
* `mysql`
* `kafka`
* `kafka connect`
* `schema registry`
* `avro converter`

# 기능적 요구사항
* 게시판을 생성할 수 있다.
* 게시판에 댓글을 달 수 있다.
* `boardId`를 기준으로 게시판을 삭제한다.
* `userId`를 기준으로 게시판을 전체 삭제한다.
* `Transactional Outbox Pattern(transation log tailing)`을 이용해 게시판 CUD 이벤트를 발행 및 보장한다.
* 데이터 변경 이벤트를 구독하여 NoSQL 형태의 readDB에 동기화를 한다.

