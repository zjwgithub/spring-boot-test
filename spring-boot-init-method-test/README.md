## 실행 결과

### 로그

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.7)

INFO 4275 --- [           main] s.s.SpringBootInitMethodTestApplication  : Starting SpringBootInitMethodTestApplication using Java 11.0.13 on iMac.local
INFO 4275 --- [           main] s.s.SpringBootInitMethodTestApplication  : No active profile set, falling back to 1 default profile: "default"
INFO 4275 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
INFO 4275 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
INFO 4275 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.62]
INFO 4275 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
INFO 4275 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 926 ms
  MyPostConstruct
INFO 4275 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
INFO 4275 --- [           main] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
INFO 4275 --- [           main] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
INFO 4275 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
INFO 4275 --- [           main] s.s.SpringBootInitMethodTestApplication  : Started SpringBootInitMethodTestApplication in 1.697 seconds (JVM running for 2.336)
  MyApplicationRunner
  MyCommandLineRunner
  MyCommandLineRunner2
  MyApplicationEventListener.applicationReady
```

### 실행 순서
```
MyPostConstruct
MyApplicationRunner
MyCommandLineRunner
MyCommandLineRunner2
MyApplicationEventListener.applicationReady
```

<br>

## source code

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

### MyApplicationEventListener.java
- `@EventListener` 애노테이션 사용
```java
@Component
public class MyApplicationEventListener {
    
    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        System.out.println("  MyApplicationEventListener.applicationReady");
    }
}
```
