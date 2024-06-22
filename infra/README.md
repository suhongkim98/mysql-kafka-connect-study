# Docker로 infra 구축

## 1. docker-compose up

### 1-1. docker run
```
docker compose up
```
- mysql은 `schema.sql`을 초기화하며 DB를 생성
- kafka connect는 구동하며 source connector에서 사용할 데비지움 커넥터를 설치 (command 참고)

### 1-2. kafka ui 접속
```
http://localhost:9000
```

### 1-3. mongo express 접속
```
http://localhost:9001
```


## 2. Kafka Connect source connector 붙이기

### 2-1. connector 연결
```bash
curl -X POST -H "Content-Type: application/json" \
-d @./source-connector/source.json http://localhost:8083/connectors -w "\n"
```

### 2-2. connector 연결 확인
```
curl -X GET -H "Content-Type: application/json" \
http://localhost:8083/connectors
```
```
curl -X GET -H "Content-Type: application/json" \
http://localhost:8083/connectors/{커넥터}
```

## 3. Schema Registry

### 3-1. 등록된 스키마 조회
```
curl localhost:8081/subjects
```
```
curl localhost:8081/subjects/{값}/versions
```
```
curl localhost:8081/subjects/{값}/versions/1
```

### 3-2. 설정 조회
```
curl -X GET http://localhost:8081/config
```