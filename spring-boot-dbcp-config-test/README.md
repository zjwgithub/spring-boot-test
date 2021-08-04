### build.gradle
    compile 'com.zaxxer:HikariCP'
    compile 'org.apache.tomcat:tomcat-jdbc'
    
### application.yaml
- #### HikariCP
        spring.datasource.type: com.zaxxer.hikari.HikariDataSource
        spring.datasource.hikari.pool-name: dbcp-hikari-test
- #### Tomcat JDBC CP
        spring.datasource.type: org.apache.tomcat.jdbc.pool.DataSource
        spring.datasource.tomcat.name: dbcp-tomcat-test

