# mysql-kafka-connect-study
![arch-overview.png](docs%2Farch-overview.png)
가볍게 `mysql` source connector 학습하기
# 아키텍처
![arch-detail.png](docs%2Farch-detail.png)

# 기술스택
* `spring boot`
* `mysql`
* `kafka`
* `kafka connect`
* `schema registry`
* `avro converter`

# 기능적 요구사항
* 게시판을 생성할 수 있다. (O)
* 게시판에 댓글을 달 수 있다. (O)
* `boardId`를 기준으로 게시판을 삭제한다. (O)
* 게시판을 전체 삭제할 수 있다. (O)
* `Transactional Outbox Pattern(transation log tailing)`을 이용해 게시판 CUD 이벤트를 발행 및 보장한다. (O)
* 데이터 변경 이벤트를 구독하여 NoSQL 형태의 readDB에 동기화를 한다.(`CQRS 패턴`) (-)

# 시작하기
## 로컬 인프라 구축
```bash
cd ./infra
cat README.md
```

