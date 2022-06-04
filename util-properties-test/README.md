# `util:properties` 테스트

## properties 파일 만들기
```properties
# common.properties

server.host=my-server-host
server.port=8088
```
```properties
# db.properties

datasource.driverClassName=org.h2.Driver
datasource.url=jdbc:h2:tcp://localhost/~/local-db
datasource.username=sa
datasource.password=
```

## beans xml 만들기
- `util:properties` 로 `id` 를 부여해서 각각 등록한다
```xml
<!-- properties-config.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/util https://www.springframework.org/schema/util/spring-util.xsd
">

    <util:properties id="common" location="classpath:properties/common.properties"/>
    <util:properties id="db" location="classpath:properties/db.properties"/>

</beans>
```

## java config 만들기
`@ImportResource` 를 이용해서 `properties-config.xml` 파일을 로드한다
```java
@Configuration
@ImportResource("classpath:properties/properties-config.xml")
public class PropertyConfig {

}
```
`common.properties` 내용을 담을 CommonProps 생성
```java
@Getter @Setter
@ToString
@Component
public class CommonProps {

    @Value("#{common['server.host']}")
    private String serverHost;

    @Value("#{common['server.port']}")
    private int serverPort;

}
```
`db.properties` 내용을 담을 DbProps 생성
```java
@Getter @Setter
@ToString
@Component
public class DbProps {

    @Value("#{db['datasource.driverClassName']}")
    private String driverClassName;

    @Value("#{db['datasource.url']}")
    private String url;

    @Value("#{db['datasource.username']}")
    private String username;

    @Value("#{db['datasource.password']}")
    private String password;
}
```

## 테스트
```java
@SpringBootTest
class PropertyConfigTest {

    @Autowired
    CommonProps commonProps;

    @Autowired
    DbProps dbProps;

    @Value("#{common['server.host']}")
    String serverHost;

    @Value("#{db['datasource.driverClassName']}")
    String driverClassName;

    @Test
    void propTest() {
        System.out.println("commonProps = " + commonProps);
        System.out.println("dbProps = " + dbProps);
        System.out.println("serverHost = " + serverHost);
        System.out.println("driverClassName = " + driverClassName);

        assertThat(serverHost).isEqualTo("my-server-host");
        assertThat(driverClassName).isEqualTo("org.h2.Driver");
    }
}
```
console 출력
```properties
commonProps = CommonProps(serverHost=my-server-host, serverPort=8088)
dbProps = DbProps(driverClassName=org.h2.Driver, url=jdbc:h2:tcp://localhost/~/local-db, username=sa, password=)
serverHost = my-server-host
driverClassName = org.h2.Driver
```

## controller 에서 사용
```java
@RestController
@RequiredArgsConstructor
public class IndexController {

    private final CommonProps commonProps;
    private final DbProps dbProps;

    @Value("#{common['server.host']}")
    private String serverHost;

    @Value("#{db['datasource.driverClassName']}")
    private String driverClassName;

    @GetMapping("/")
    public String index() {
        System.out.println("commonProps = " + commonProps);
        System.out.println("dbProps = " + dbProps);
        System.out.println("serverHost = " + serverHost);
        System.out.println("driverClassName = " + driverClassName);
        return "ok";
    }
}
```
