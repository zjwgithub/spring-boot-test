
## Filter, Interceptor 테스트

## /hello (정상 흐름)

- was > filter1 > filter2 > interceptor1 > interceptor2 > controller
- `DispatcherType.REQUEST` 로 요청을 호출한다

```
## LogFilter         | doFilter 시작, REQUEST GET /hello
## AuthFilter        | doFilter 시작, REQUEST GET /hello

## LogInterceptor    | preHandle, REQUEST GET /hello
## AuthInterceptor   | preHandle, REQUEST GET /hello

## HelloController   | 시작
## HelloController   | 종료

## AuthInterceptor   | postHandle, REQUEST GET /hello
## LogInterceptor    | postHandle, REQUEST GET /hello
## AuthInterceptor   | afterCompletion, REQUEST GET /hello
## LogInterceptor    | afterCompletion, REQUEST GET /hello

## AuthFilter        | doFilter 종료, REQUEST GET /hello
## LogFilter         | doFilter 종료, REQUEST GET /hello
```

## /ex (예외가 발생한 경우)

- controller 에서 예외가 발생한 경우 interceptor 의 `postHandle` 이 호출되지 않는다
- 예외는 was 까지 올라가서 예외 로그를 출력하고
- was 는 다시 `DispatcherType.ERROR` 로 `/error` 요청을 호출한다

```
## LogFilter         | doFilter 시작, REQUEST GET /ex
## AuthFilter        | doFilter 시작, REQUEST GET /ex

## LogInterceptor    | preHandle, REQUEST GET /ex
## AuthInterceptor   | preHandle, REQUEST GET /ex

## HelloController   | RuntimeException 예외 발생

## AuthInterceptor   | afterCompletion, REQUEST GET /ex
## LogInterceptor    | afterCompletion, REQUEST GET /ex

## AuthFilter        | doFilter 에러, org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.RuntimeException: RuntimeException 예외 발생
## AuthFilter        | doFilter 종료, REQUEST GET /ex
## LogFilter         | doFilter 에러, org.springframework.web.util.NestedServletException: Request processing failed; nested exception is java.lang.RuntimeException: RuntimeException 예외 발생
## LogFilter         | doFilter 종료, REQUEST GET /ex
2022-05-29 09:18:21.965 ERROR 1907 --- [nio-8080-exec-4] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.RuntimeException: RuntimeException 예외 발생] with root cause

java.lang.RuntimeException: RuntimeException 예외 발생
	at study.boottest.controller.HelloController.ex(HelloController.java:29) ~[main/:na]
	...

## LogInterceptor    | preHandle, ERROR GET /error
## AuthInterceptor   | preHandle, ERROR GET /error
## AuthInterceptor   | postHandle, ERROR GET /error
## LogInterceptor    | postHandle, ERROR GET /error
## AuthInterceptor   | afterCompletion, ERROR GET /error
## LogInterceptor    | afterCompletion, ERROR GET /error

```

## /ex-with-handler (예외가 발생했지만 @ExceptionHandler 로 처리한 경우)

- controller 에서 예외가 발생한 경우 `@ExceptionHandler` 가 예외를 처리한다
- 이후에는 정상 흐름처럼 동작한다

```
## LogFilter         | doFilter 시작, REQUEST GET /ex-with-handler
## AuthFilter        | doFilter 시작, REQUEST GET /ex-with-handler

## LogInterceptor    | preHandle, REQUEST GET /ex-with-handler
## AuthInterceptor   | preHandle, REQUEST GET /ex-with-handler

## HelloController   | IllegalStateException 예외 발생
## HelloController   | IllegalStateException 예외 핸들링
2022-05-29 09:21:14.056  WARN 2039 --- [nio-8080-exec-2] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [java.lang.IllegalStateException: IllegalStateException 예외 발생]

## AuthInterceptor   | afterCompletion, REQUEST GET /ex-with-handler
## LogInterceptor    | afterCompletion, REQUEST GET /ex-with-handler

## AuthFilter        | doFilter 종료, REQUEST GET /ex-with-handler
## LogFilter         | doFilter 종료, REQUEST GET /ex-with-handler
```
