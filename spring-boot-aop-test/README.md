## 의존성 추가
```groovy
implementation 'org.springframework.boot:spring-boot-starter-aop'
```

## Aspect 만들기
```java
@Component // 빈으로 등록해줘야 한다
@Aspect
public class MethodParamAspect {
    
}
```

## Aspect 안에 Advice 와 Pointcut 를 추가
- `Advice` 부가 기능 로직
- `Pointcut` 부가 기능이 실행될 위치를 지정

### @Around
- `@Around` 만 `ProceedingJoinPoint` 를 사용
```java
@Around("execution(* my.study..repository..*(..))") // Poitncut
public Object around(ProceedingJoinPoint joinPoint) throws Throwable { // Advice
    log.info(joinPoint.getSignature());
    Object result = joinPoint.proceed(); 
    return result;
}
```

### @Before
```java
@Before("execution(* my.study..*(..))")
public void before(JoinPoint joinPoint) {
}
```

### @AfterReturning
- 파라미터 이름을 맞춰줘야 함 `returning = "result"` `Object result`
```java
@AfterReturning(value = "execution(* my.study..service..*(..))", returning = "result")
public void afterReturning(JoinPoint joinPoint, Object result) {
}
```

### @AfterThrowing
- 파라미터 이름을 맞춰줘야 함 `throwing = "ex"` `Exception ex`
```java
@AfterThrowing(value = "execution(* my.study..service..*(..))", throwing = "ex")
public void afterThrowing(JoinPoint joinPoint, Exception ex) {
}
```

### @After
```java
@After("execution(* my.study..service..*(..))")
public void after(JoinPoint joinPoint) {
}
```
