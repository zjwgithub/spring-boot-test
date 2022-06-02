## 요약
서버 시작시 서블릿 로딩 설정 등록
```properties
# application.properties

spring.mvc.servlet.load-on-startup=1
```
위 설정 추가시 아래 로그가 출력된다
```
INFO 6122 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
INFO 6122 --- [           main] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
INFO 6122 --- [           main] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
```
서버 시작시 할 작업을 `ApplicationReadyEvent` 이벤트에 등록
```java
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;

@RequiredArgsConstructor
@Component
public class MyApplicationEventListener {

    private final ApplicationContext applicationContext;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent() {
        System.out.println("MyApplicationEventListener.applicationReadyEvent");
        System.out.println("applicationContext = " + applicationContext);
        // applicationContext = org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@158a3b2e
    }
}
```

<br>

## 실행순서
- `ApplicationReadyEvent` 가 가장 마지막에 실행된다
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.0)

INFO 6122 --- [           main] pringBootApplicationEventTestApplication : Starting SpringBootApplicationEventTestApplication using Java 11.0.13
INFO 6122 --- [           main] pringBootApplicationEventTestApplication : No active profile set, falling back to 1 default profile: "default"
INFO 6122 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
INFO 6122 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
INFO 6122 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.63]
INFO 6122 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
INFO 6122 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in  ms
INFO 6122 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
INFO 6122 --- [           main] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
INFO 6122 --- [           main] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
INFO 6122 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''

MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent
MyApplicationEventListener.applicationEvent, event=class org.springframework.context.event.ContextRefreshedEvent
MyApplicationEventListener.applicationContextEvent
MyApplicationEventListener.contextRefreshedEvent

INFO 6122 --- [           main] pringBootApplicationEventTestApplication : Started SpringBootApplicationEventTestApplication

MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.context.event.ApplicationStartedEvent
MyApplicationEventListener.applicationStartedEvent
MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.availability.AvailabilityChangeEvent
MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.context.event.ApplicationReadyEvent
MyApplicationEventListener.applicationReadyEvent
MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.availability.AvailabilityChangeEvent
```
```
MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent
MyApplicationEventListener.applicationEvent, event=class org.springframework.context.event.ContextRefreshedEvent

MyApplicationEventListener.applicationContextEvent
MyApplicationEventListener.contextRefreshedEvent

MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.context.event.ApplicationStartedEvent

MyApplicationEventListener.applicationStartedEvent

MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.availability.AvailabilityChangeEvent
MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.context.event.ApplicationReadyEvent

MyApplicationEventListener.applicationReadyEvent

MyApplicationEventListener.applicationEvent, event=class org.springframework.boot.availability.AvailabilityChangeEvent
```

<br>

## MyApplicationEventListener
```java
@Component
public class MyApplicationEventListener {

    @EventListener(ApplicationEvent.class)
    public void applicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationEventListener.applicationEvent, event=" + event.getClass());
    }

    @EventListener(ApplicationContextInitializedEvent.class)
    public void applicationContextInitializedEvent() {
        System.out.println("MyApplicationEventListener.applicationContextInitializedEvent");
    }

    @EventListener(ApplicationEnvironmentPreparedEvent.class)
    public void applicationEnvironmentPreparedEvent() {
        System.out.println("MyApplicationEventListener.applicationEnvironmentPreparedEvent");
    }

    @EventListener(ApplicationFailedEvent.class)
    public void applicationFailedEvent() {
        System.out.println("MyApplicationEventListener.applicationFailedEvent");
    }

    @EventListener(ApplicationPreparedEvent.class)
    public void applicationPreparedEvent() {
        System.out.println("MyApplicationEventListener.applicationPreparedEvent");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent() {
        System.out.println("MyApplicationEventListener.applicationReadyEvent");
    }

    @EventListener(ApplicationStartedEvent.class)
    public void applicationStartedEvent() {
        System.out.println("MyApplicationEventListener.applicationStartedEvent");
    }

    @EventListener(ApplicationStartingEvent.class)
    public void applicationStartingEvent() {
        System.out.println("MyApplicationEventListener.applicationStartingEvent");
    }

    @EventListener(ApplicationContextEvent.class)
    public void applicationContextEvent() {
        System.out.println("MyApplicationEventListener.applicationContextEvent");
    }

    @EventListener(ContextStartedEvent.class)
    public void contextStartedEvent() {
        System.out.println("MyApplicationEventListener.contextStartedEvent");
    }
    
    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        System.out.println("MyApplicationEventListener.contextRefreshedEvent");
    }
}
```
