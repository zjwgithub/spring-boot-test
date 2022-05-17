
## Filter, Interceptor 테스트

/hello

    ## LogFilter         | doFilter 시작, REQUEST GET /hello
    ## AuthFilter        | doFilter 시작, REQUEST GET /hello
    ## LogInterceptor    | preHandle, REQUEST GET /hello
    ## AuthInterceptor   | preHandle, REQUEST GET /hello
    ## HelloController   | hello
    ## AuthInterceptor   | postHandle, REQUEST GET /hello
    ## LogInterceptor    | postHandle, REQUEST GET /hello
    ## AuthInterceptor   | afterCompletion, REQUEST GET /hello
    ## LogInterceptor    | afterCompletion, REQUEST GET /hello
    ## AuthFilter        | doFilter 종료, REQUEST GET /hello
    ## LogFilter         | doFilter 종료, REQUEST GET /hello

/ex (no @ExceptionHandler)

    ## LogFilter         | doFilter 시작, REQUEST GET /ex
    ## AuthFilter        | doFilter 시작, REQUEST GET /ex
    ## LogInterceptor    | preHandle, REQUEST GET /ex
    ## AuthInterceptor   | preHandle, REQUEST GET /ex
    ## AuthInterceptor   | afterCompletion, REQUEST GET /ex
    ## LogInterceptor    | afterCompletion, REQUEST GET /ex
    ## AuthFilter        | doFilter 에러, org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.RuntimeException: raiseEx 발생
    ## AuthFilter        | doFilter 종료, REQUEST GET /ex
    ## LogFilter         | doFilter 에러, org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.RuntimeException: raiseEx 발생
    ## LogFilter         | doFilter 종료, REQUEST GET /ex
    2021-08-25 17:29:28.064 ERROR 8320 --- [nio-8080-exec-4] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.RuntimeException: raiseEx 발생] with root cause
    
    java.lang.RuntimeException: raiseEx 발생
    at study.boottest.controller.HelloController.raiseEx(HelloController.java:22) ~[classes/:na]
    
    ## LogInterceptor    | preHandle, ERROR GET /error
    ## AuthInterceptor   | preHandle, ERROR GET /error
    ## AuthInterceptor   | postHandle, ERROR GET /error
    ## LogInterceptor    | postHandle, ERROR GET /error
    ## AuthInterceptor   | afterCompletion, ERROR GET /error
    ## LogInterceptor    | afterCompletion, ERROR GET /error


/ex (with @ExceptionHandler)

    ## LogFilter         | doFilter 시작, REQUEST GET /ex
    ## AuthFilter        | doFilter 시작, REQUEST GET /ex
    ## LogInterceptor    | preHandle, REQUEST GET /ex
    ## AuthInterceptor   | preHandle, REQUEST GET /ex
    ## HelloController   | handleEx java.lang.RuntimeException: raiseEx 발생
    2021-08-25 17:30:44.430  WARN 8339 --- [nio-8080-exec-2] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [java.lang.RuntimeException: raiseEx 발생]
    ## AuthInterceptor   | afterCompletion, REQUEST GET /ex
    ## LogInterceptor    | afterCompletion, REQUEST GET /ex
    ## AuthFilter        | doFilter 종료, REQUEST GET /ex
    ## LogFilter         | doFilter 종료, REQUEST GET /ex
