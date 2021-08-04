### build.gradle
    runtimeOnly 'com.oracle.ojdbc:ojdbc8'
    runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'

### application.yaml
    member:
      datasource:
        driverClassName: oracle.jdbc.driver.OracleDriver
        jdbcUrl: jdbc:oracle:thin:@dbhost:1521/orclcdb
        username: mytestdb
        password: test!234
      jpa:
        hibernate:
          hbm2ddl.auto: create
          dialect: org.hibernate.dialect.Oracle12cDialect
    
    product:
      datasource:
        driverClassName: org.mariadb.jdbc.Driver
        jdbcUrl: jdbc:mariadb://dbhost:3306/mytestdb
        username: root
        password: test!234
      jpa:
        hibernate:
          hbm2ddl.auto: create
          dialect: org.hibernate.dialect.MariaDB103Dialect

### MemberPersistenceConfig
    @Configuration
    @PropertySource({"classpath:application.yaml"})
    @EnableJpaRepositories(
            basePackages = "study.springbootmultipledatasourcetest.member",
            entityManagerFactoryRef = "memberEntityManagerFactory",
            transactionManagerRef = "memberTransactionManager"
    )
    public class MemberPersistenceConfig {
    
        @Autowired
        private Environment env;
    
        @Primary
        @Bean
        @ConfigurationProperties(prefix = "member.datasource")
        public DataSource memberDataSource() {
            return DataSourceBuilder.create().build();
        }
    
        @Primary
        @Bean
        public LocalContainerEntityManagerFactoryBean memberEntityManagerFactory() {
            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto", env.getProperty("member.jpa.hibernate.hbm2ddl.auto"));
            properties.put("hibernate.dialect", env.getProperty("member.jpa.hibernate.dialect"));
    
            LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
            emf.setDataSource(memberDataSource());
            emf.setPackagesToScan(new String[]{"study.springbootmultipledatasourcetest.member"});
            emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            emf.setJpaPropertyMap(properties);
            return emf;
        }
    
        @Primary
        @Bean
        public PlatformTransactionManager memberTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(memberEntityManagerFactory().getObject());
            return transactionManager;
        }
    }

### ProductPersistenceConfig
    @Configuration
    @PropertySource({"classpath:application.yaml"})
    @EnableJpaRepositories(
            basePackages = "study.springbootmultipledatasourcetest.product",
            entityManagerFactoryRef = "productEntityManagerFactory",
            transactionManagerRef = "productTransactionManager"
    )
    public class ProductPersistenceConfig {
    
        @Autowired
        private Environment env;
    
        @Bean
        @ConfigurationProperties(prefix = "product.datasource")
        public DataSource productDataSource() {
            return DataSourceBuilder.create().build();
        }
    
        @Bean
        public LocalContainerEntityManagerFactoryBean productEntityManagerFactory() {
            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto", env.getProperty("product.jpa.hibernate.hbm2ddl.auto"));
            properties.put("hibernate.dialect", env.getProperty("product.jpa.hibernate.dialect"));
    
            LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
            emf.setDataSource(productDataSource());
            emf.setPackagesToScan(new String[]{"study.springbootmultipledatasourcetest.product"});
            emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            emf.setJpaPropertyMap(properties);
            return emf;
        }
    
        @Bean
        public PlatformTransactionManager productTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(productEntityManagerFactory().getObject());
            return transactionManager;
        }
    }
