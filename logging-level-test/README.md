## application.yml
```yaml
logging:
  level:
    root: info
    org.apache.coyote.http11: debug
    org.springframework: debug
    org.springframework.boot.autoconfigure.logging: info
    com.zaxxer.hikari: debug
    org.thymeleaf: debug
    org.thymeleaf.TemplateEngine.CONFIG: info

spring:
  mvc:
    servlet:
      load-on-startup: 1
```
