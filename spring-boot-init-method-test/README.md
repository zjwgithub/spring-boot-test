### MyPostConstruct.java
    @Component
    public class MyPostConstruct {
    
        @PostConstruct
        public void run() {
            System.out.println();
            System.out.println("MyPostConstruct");
            System.out.println();
        }
    }

### MyApplicationRunner.java
    @Component
    public class MyApplicationRunner implements ApplicationRunner {
    
        @Override
        public void run(ApplicationArguments args) throws Exception {
            System.out.println();
            System.out.println("MyApplicationRunner");
            System.out.println();
        }
    }

### MyCommandLineRunner.java
    @Component
    public class MyCommandLineRunner implements CommandLineRunner {
    
        @Override
        public void run(String... args) throws Exception {
            System.out.println();
            System.out.println("MyCommandLineRunner");
            System.out.println();
        }
    }

### MyCommandLineRunner2.java
    @Component
    public class MyCommandLineRunner2 {
    
        @Bean
        public CommandLineRunner run() {
            return args -> {
                System.out.println();
                System.out.println("MyCommandLineRunner2");
                System.out.println();
            };
        }
    }

### 실행 순서
    MyPostConstruct
    MyApplicationRunner
    MyCommandLineRunner
    MyCommandLineRunner2

### 로그
      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::                (v2.4.0)
    
    2020-11-15 18:11:00.074  INFO 10803 --- [           main] s.s.SpringBootInitMethodTestApplication  : Starting SpringBootInitMethodTestApplication using Java 11.0.8 on MacBookPro.local with PID 10803
    2020-11-15 18:11:00.076  INFO 10803 --- [           main] s.s.SpringBootInitMethodTestApplication  : No active profile set, falling back to default profiles: default
    
    MyPostConstruct
    
    2020-11-15 18:11:00.610  INFO 10803 --- [           main] s.s.SpringBootInitMethodTestApplication  : Started SpringBootInitMethodTestApplication in 0.958 seconds (JVM running for 3.968)
    
    MyApplicationRunner
    
    MyCommandLineRunner
    
    MyCommandLineRunner2
