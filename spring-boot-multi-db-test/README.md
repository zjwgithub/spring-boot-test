### build.gradle
    runtimeOnly 'com.oracle.ojdbc:ojdbc8'
    runtimeOnly 'mysql:mysql-connector-java'
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
    runtimeOnly 'org.postgresql:postgresql'
    runtimeOnly 'com.microsoft.sqlserver:mssql-jdbc'

### application.yaml
- ### H2
        org.h2.Driver
        jdbc:h2:tcp://localhost/~/mytestdb
        sa / 
        org.hibernate.dialect.H2Dialect

- ### Oracle
        oracle.jdbc.driver.OracleDriver
        jdbc:oracle:thin:@dbhost:1521/orclcdb
        mytestdb / test!234
        org.hibernate.dialect.Oracle12cDialect

- ### MySql
        com.mysql.cj.jdbc.Driver
        jdbc:mysql://dbhost:3306/mytestdb
        root / test!234
        org.hibernate.dialect.MySQL8Dialect

- ### MariaDB
        org.mariadb.jdbc.Driver
        jdbc:mariadb://dbhost:3306/mytestdb
        root / test!234
        org.hibernate.dialect.MariaDB103Dialect

- ### Postgresql
        org.postgresql.Driver
        jdbc:postgresql://dbhost:5432/mytestdb
        postgres / test!234
        org.hibernate.dialect.PostgreSQL10Dialect

- ### MSSQL
        com.microsoft.sqlserver.jdbc.SQLServerDriver
        jdbc:sqlserver://dbhost:1433;databaseName=mytestdb
        sa / test!234
        org.hibernate.dialect.SQLServer2012Dialect
