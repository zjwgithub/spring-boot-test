# CORS 테스트

## Origin
- 이레 3개의 조합을 Origin 이라고 한다
    - 프로토콜 (http, https)
    - 호스트이름 (localhost, 127.0.0.1)
    - 포트번호 (80, 8080)
- 동일 Origin 이란
    - 프로토콜, 호스트이름, 포트번호 가 모두 같아야 한다


## SOP
- Same Origin Policy
- 동일 출처 정책

SOP 정책은 같은 Origin 에만 요청을 보낼 수 있다

Origin 이 다르면 ajax 요청을 보낼 수 없다

## CORS
- Cross-Origin Resource Sharing
- 교차 출처 리소스 공유

## 테스트
서버를 2개 띄운다
```bash
java -jar -Dserver.port=8080 build/libs/spring-boot-cors-test-0.0.1-SNAPSHOT.jar
java -jar -Dserver.port=8081 build/libs/spring-boot-cors-test-0.0.1-SNAPSHOT.jar
```

`http://localhost:8080` 에 접속해서 `post http://localhost:8081/items` 버튼을 클릭해 본다


## CORS 허용

### 1. @CrossOrigin 사용

클래스 레벨에 적어주거나
```java
@CrossOrigin("http://localhost:8080")
@Slf4j
@RestController
public class ItemController {
    // ...
}
```

메소드 레벨에 적어준다
```java
@CrossOrigin("http://localhost:8080")
@PostMapping("/items")
public ResultDto addItems(@RequestBody ItemForm itemForm) {
    log.info("itemForm={}", itemForm);
    ResultDto resultDto = new ResultDto(true, "ok");
    log.info("resultDto={}", resultDto);
    return resultDto;
}
```

### 2. WebMvcConfigurer 사용



### 3. CorsFilter 사용


