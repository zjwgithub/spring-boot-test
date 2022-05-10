
## thymeleaf 와 jsp 같이 사용하기

- ### packaging war
```groovy
// build.gradle

id 'war'
```

- ### jsp 의존성 추가
```groovy
// build.gradle

// jsp 의존성 추가
implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'
implementation 'javax.servlet:jstl'
```

- ### view config 설정
```properties
# application.properties

# jsp
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp

# thymeleaf
spring.thymeleaf.prefix=classpath:templates/
spring.thymeleaf.suffix=.html
spring.thymeleaf.cache=false
spring.thymeleaf.view-names=thymeleaf/*
```

- ### jsp view 파일 추가
```bash
src/main/webapp/WEB-INF/views/items/item.jsp
```

- ### thymeleaf view 파일 추가
```bash
src/main/resources/templates/thymeleaf/members/member.html
```

- ### ViewTemplateController
```java
@Controller
public class ViewTemplateController {

    @GetMapping("/view-jsp")
    public String jspView() {
        return "items/item";
    }

    @GetMapping("/view-thymeleaf")
    public String thymeleafView() {
        return "thymeleaf/members/member";
    }

}
```
