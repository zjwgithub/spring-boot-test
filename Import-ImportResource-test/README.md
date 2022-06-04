# `@Import` vs `@ImportResource` 테스트

## Service 클래스 생성
`@Service` 애노테이션 없이 생성한다
```java
public class ItemService {

    public String hello() {
        return "hello item";
    }
}
```
```java
public class MemberService {

    public String hello() {
        return "hello member";
    }
}
```

## java config 만들기
MemberService 는 java config 에서 빈으로 등록
```java
@Configuration
public class MemberConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }
}
```

## xml config 만들기
ItemService 는 xml config 에서 빈으로 등록
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
">

    <bean name="itemService" class="study.importimportresourcetest.service.ItemService" />

</beans>
```

## config 로딩
- `@Import` 로 java config 를 로드
- `@ImportResource` 로 xml config 를 로드
```java
@SpringBootApplication
@Import(MemberConfig.class) // java config
@ImportResource("classpath:item-config.xml") // xml config
public class ImportImportResourceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportImportResourceTestApplication.class, args);
    }

}
```

## 테스트
```java
@SpringBootTest
public class ImportTest {

    @Autowired
    MemberService memberService; // 빈을 주입받는다

    @Autowired
    ItemService itemService; // 빈을 주입받는다

    @Test
    void name() {
        assertThat(memberService.hello()).isEqualTo("hello member");
        assertThat(itemService.hello()).isEqualTo("hello item");
    }
}
```
