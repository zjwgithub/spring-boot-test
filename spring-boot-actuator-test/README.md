### build.gradle
    implementation 'org.springframework.boot:spring-boot-starter-actuator'

### application.yaml
    management.endpoints.web.exposure.include: "*"

### actuator endpoints
    http://localhost:8080/actuator

### log level trace 로 변경하기
    curl -X POST -i localhost:8080/actuator/loggers/study \
        -H 'Content-Type: application/json' \
        -d '{"configuredLevel": "trace"}'
