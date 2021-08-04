package my.study.springbootaoptest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {

    public static final String NL = "\n";
    public static final String TAB = "    ";

    @Before("execution(* my.study..controller..*(..))")
//    @Before("execution(* my.study..service..*(..))")
//    @Before("execution(* my.study..repository..*(..))")
//    @Before("execution(* my.study..member..*(..))")
//    @Before("execution(* my.study..product..*(..))")
//    @Before("execution(* my.study..*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("-----------------before " + getMethodInfo(joinPoint));
    }

//    @After("execution(* my.study..service..*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("-----------------after " + getMethodInfo(joinPoint));
    }

//    @Around("execution(* my.study..repository..*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----------------around start " + getMethodInfo(joinPoint));
        Object result = joinPoint.proceed();
        System.out.println("-----------------around end " + getMethodInfo(joinPoint));
        return result;
    }

    @AfterReturning(value = "execution(* my.study..service..*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("-----------------afterReturning " + getMethodInfo(joinPoint));
        System.out.println("result = " + result);
    }

    @AfterThrowing(value = "execution(* my.study..service..*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("-----------------afterThrowing " + getMethodInfo(joinPoint));
        System.out.println(e.getClass().getSimpleName());
        System.out.println(e.getMessage());
    }

    private Throwable getRootCause(Throwable e) {
        while (e.getCause() != null) {
            e = e.getCause();
        }
        return e;
    }

    private String getMethodInfo(JoinPoint joinPoint) {
        return getMethodName(joinPoint) + NL + getArgs(joinPoint);
    }

    private String getMethodName(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        sb.append(joinPoint.getSignature().getDeclaringType().getSimpleName());
        sb.append(".");
        sb.append(joinPoint.getSignature().getName());
        return sb.toString();
    }

    private String getArgs(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            sb.append(TAB);
            sb.append(i + ": " + args[i]);
            sb.append(NL);
        }
        return sb.toString();
    }
}
