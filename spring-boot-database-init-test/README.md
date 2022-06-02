# `schema.sql`, `data.sql` 사용법

의존성 추가
- `jpa` 의존성을 추가한다
- `h2` DB Driver 의존성을 추가한다
```groovy
// build.gradle

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa' // jpa 의존성이 없으면 테이블이 생성되지 않음
    runtimeOnly 'com.h2database:h2'
}
```

datasource 설정
- datasource 만 정의한 경우는 테이블이 생성되지 않는다
```properties
# src/main/resources/application.properties

spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:tcp://localhost/~/local-db
spring.datasource.username=sa
spring.datasource.password=
```

로깅 설정
```properties
# src/main/resources/application.properties

logging.level.root=info
logging.level.org.springframework=debug
logging.level.org.springframework.boot.autoconfigure=info
logging.level.org.springframework.jdbc.datasource.init=debug
logging.level.org.hibernate.SQL=debug
```

<br>

## SQL 테스트
```sql
/*
insert into item (id, item_name, price, quantity) values (1, 'itemX', 1000, 10);
insert into item (id, item_name, price, quantity) values (2, 'itemY', 1000, 10);
drop table item if exists;
drop table my_item if exists;
drop table my_item_h2 if exists;
drop table sql_my_item if exists;
*/
select * from item;
select * from my_item;
select * from my_item_h2;
select * from sql_my_item;
```

<br>

## `@Entity` 애노테이션으로 테이블 생성하기
- Entity 클래스를 정의하고
```java
@Getter @Setter
@Entity
public class Item {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String itemName;
    private Integer price;
    private Integer quantity;
}
```
- 아래 옵션을 주고 실행한다
```properties
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.format_sql=true
```
```properties
# ddl-auto 설정별 동작

# 기본 설정
spring.jpa.hibernate.ddl-auto=none

# 애플리케이션 시작시: 테이블을 create 한다 (테이블이 이미 있으면 drop 하고 만든다)
# 애플리케이션 종료시: 테이블을 drop 하지 않는다
spring.jpa.hibernate.ddl-auto=create

# 애플리케이션 시작시: 테이블을 create 한다 (테이블이 이미 있으면 drop 하고 만든다)
# 애플리케이션 종료시: 테이블을 drop 한다
spring.jpa.hibernate.ddl-auto=create-drop

# 필요한 경우 스키마를 업데이트
spring.jpa.hibernate.ddl-auto=update

# 스키마가 유효한지만 체크
spring.jpa.hibernate.ddl-auto=validate
```

<br>

## `schema.sql`, `data.sql` 파일로 테이블 생성하기
- `@Entity` 애노테이션을 사용하지 않는 경우에 사용한다

### 기본 동작
- `application.properties`
    ```properties
    # 아래 옵션을 줘야 임베디드 DB 가 아니라도 파일을 실행시킨다
    spring.sql.init.mode=always
  
    # 아래 옵션은 주석 처리한다
    # spring.jpa.hibernate.ddl-auto=create
    ```
- 파일 위치
  - `src/main/resources/schema.sql`
  - `src/main/resources/data.sql`

### 다른 위치로 지정하려면
- `application.properties`
    ```properties
    spring.sql.init.mode=always
    spring.sql.init.schema-locations=classpath:sql/schema.sql
    spring.sql.init.data-locations=classpath:sql/data.sql
    ```
- 파일 위치
  - `src/main/resources/sql/schema.sql`
  - `src/main/resources/sql/data.sql`

### platform 을 구분
- `application.properties`
    ```properties
    spring.sql.init.mode=always
    spring.sql.init.platform=h2
    ```
- 파일 위치
  - `src/main/resources/schema-h2.sql`
  - `src/main/resources/data-h2.sql`

<br>

## application.properties
```properties

spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:tcp://localhost/~/local-db
spring.datasource.username=sa
spring.datasource.password=

#---------------------------------------------------------

#spring.h2.console.enabled=true
#spring.h2.console.path=/h2-console

spring.sql.init.mode=always
spring.sql.init.schema-locations=classpath:sql/schema.sql
spring.sql.init.data-locations=classpath:sql/data.sql
#spring.sql.init.platform=h2
#spring.sql.init.continue-on-error=true
#spring.sql.init.encoding=UTF-8
#spring.sql.init.separator=;
#spring.sql.init.username=sa
#spring.sql.init.password=

#spring.jpa.generate-ddl=true
#spring.jpa.hibernate.ddl-auto=create
#spring.jpa.show-sql=true
#spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

#---------------------------------------------------------

#spring.mvc.servlet.load-on-startup=1

logging.level.root=info
logging.level.org.springframework=debug
logging.level.org.springframework.boot.autoconfigure=info
logging.level.org.springframework.jdbc.datasource.init=debug
logging.level.org.hibernate.SQL=debug

```
