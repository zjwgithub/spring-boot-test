## application.yml
```yaml
logging.level:
  root: info
  org.apache.coyote.http11: debug
  org.springframework: debug
  org.springframework.boot.autoconfigure.logging: info
  com.zaxxer.hikari: debug
  org.thymeleaf: debug
  org.thymeleaf.TemplateEngine.CONFIG: info

spring.mvc.servlet.load-on-startup: 1
```

## application.properties
```properties
logging.level.root=info
logging.level.org.apache.coyote.http11=debug
logging.level.org.springframework=debug
logging.level.org.springframework.boot.autoconfigure.logging=info
logging.level.com.zaxxer.hikari=debug
logging.level.org.thymeleaf=debug
logging.level.org.thymeleaf.TemplateEngine.CONFIG=info

spring.mvc.servlet.load-on-startup=1
```
