## build.gradle
```gradle
dependencies {
    runtimeOnly 'com.oracle.ojdbc:ojdbc8'
    runtimeOnly 'mysql:mysql-connector-java'
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
    runtimeOnly 'org.postgresql:postgresql'
    runtimeOnly 'com.microsoft.sqlserver:mssql-jdbc'
}
```


## application.yaml
- ### H2
```properties
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:tcp://localhost/~/mytestdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
```

- ### Oracle
```properties
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@dbhost:1521/orclcdb
spring.datasource.username=sys
spring.datasource.password=test!234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect
```

- ### MySql
```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://dbhost:3306/mytestdb
spring.datasource.username=root
spring.datasource.password=test!234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

- ### MariaDB
```properties
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://dbhost:3306/mytestdb
spring.datasource.username=root
spring.datasource.password=test!234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDB103Dialect
```

- ### Postgresql
```properties
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://dbhost:5432/mytestdb
spring.datasource.username=postgres
spring.datasource.password=test!234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL10Dialect
```

- ### MSSQL
```properties
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.url=jdbc:sqlserver://dbhost:1433;databaseName=mytestdb
spring.datasource.username=sa
spring.datasource.password=test!234
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServer2012Dialect
```
