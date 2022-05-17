### 로그
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.7)

2022-05-17 10:49:11.812  INFO 11611 --- [           main] s.s.SpringBootInitMethodTestApplication  : Starting SpringBootInitMethodTestApplication using Java 11.0.13
2022-05-17 10:49:11.814  INFO 11611 --- [           main] s.s.SpringBootInitMethodTestApplication  : No active profile set, falling back to 1 default profile: "default"
2022-05-17 10:49:12.485  INFO 11611 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-05-17 10:49:12.494  INFO 11611 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-05-17 10:49:12.494  INFO 11611 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.62]
2022-05-17 10:49:12.576  INFO 11611 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-05-17 10:49:12.576  INFO 11611 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 734 ms
  MyPostConstruct
2022-05-17 10:49:12.884  INFO 11611 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-05-17 10:49:12.892  INFO 11611 --- [           main] s.s.SpringBootInitMethodTestApplication  : Started SpringBootInitMethodTestApplication in 1.29 seconds (JVM running for 1.688)
  MyApplicationRunner
  MyCommandLineRunner
  MyCommandLineRunner2
```

### 실행 순서
```
MyPostConstruct
MyApplicationRunner
MyCommandLineRunner
MyCommandLineRunner2
```

### MyPostConstruct.java
- `@PostConstruct` 애노테이션 사용
```java
@Component
public class MyPostConstruct {

    @PostConstruct
    public void run() {
        System.out.println("  MyPostConstruct");
    }
}
```

### MyApplicationRunner.java
- `ApplicationRunner` 인터페이스 구현
```java
@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("  MyApplicationRunner");
    }
}
```

### MyCommandLineRunner.java
- `CommandLineRunner` 인터페이스 구현
```java
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("  MyCommandLineRunner");
    }
}
```

### MyCommandLineRunner2.java
- `CommandLineRunner` 빈 정의
```java
@Component
public class MyCommandLineRunner2 {

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println("  MyCommandLineRunner2");
        };
    }
}
```
