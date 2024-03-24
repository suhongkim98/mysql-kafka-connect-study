# Docker로 infra 구축

## cd infra
```
cd ./infra
```

## 1. docker-compose up

### 1-1. docker run
```
docker compose up
```
- mysql은 `schema.sql`을 초기화하며 DB를 생성

### 1-2. kafka ui 접속
```
http://localhost:9000
```


## 2. source connector 붙이기

### 2-1. connector 연결
```bash
curl -X POST -H "Content-Type: application/json" \
-d @./source-connector/source.json http://localhost:8083/connectors -w "\n"
```

```
curl -X GET -H "Content-Type: application/json" \
http://localhost:8083/connectors

curl -X GET -H "Content-Type: application/json" \
http://localhost:8083/connectors/{커넥터}
```

## 3. 스키마 버전 조회
```
curl localhost:8081/subjects
curl localhost:8081/subjects/{값}/versions
curl localhost:8081/subjects/{값}/versions/1
```