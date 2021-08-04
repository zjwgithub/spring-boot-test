### Gradle
    implementation 'org.springframework.boot:spring-boot-starter-aop'

### AopConfig
    @Component
    @Aspect
    public class AopConfig {
        
    }

### @Before
    @Before("execution(* my.study..*(..))")
    public void before(JoinPoint joinPoint) {
    }

### @After
    @After("execution(* my.study..service..*(..))")
    public void after(JoinPoint joinPoint) {
    }

### @Around
    @Around("execution(* my.study..repository..*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    }

### @AfterReturning
    @AfterReturning(value = "execution(* my.study..service..*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
    }

### @AfterThrowing
    @AfterThrowing(value = "execution(* my.study..service..*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
    }
