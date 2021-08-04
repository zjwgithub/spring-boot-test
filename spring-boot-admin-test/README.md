>## github spring-boot-admin
    https://github.com/codecentric/spring-boot-admin

>## admin-server
### build.gradle
    implementation 'de.codecentric:spring-boot-admin-starter-server:2.3.1'
    implementation 'org.springframework.boot:spring-boot-starter-web'
### @EnableAdminServer
    @SpringBootApplication
    @EnableAdminServer
    public class SpringBootAdminServerApplication {
    }
### application.yaml
    server.port: 8080
### admin 실행
    htp://localhost:8080

>## admin-client-1
### build.gradle
    implementation 'de.codecentric:spring-boot-admin-starter-client:2.3.1'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
### application.yaml
    server.port: 18080
    management.endpoints.web.exposure.include: "*"
    spring.boot.admin.client.url: "http://localhost:8080"

># admin-client-2
### build.gradle
    implementation 'de.codecentric:spring-boot-admin-starter-client:2.3.1'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
### application.yaml
    server.port: 28080
    management.endpoints.web.exposure.include: "*"
    spring.boot.admin.client.url: "http://localhost:8080"
