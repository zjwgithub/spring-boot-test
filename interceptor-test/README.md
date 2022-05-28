
## 인터셉터 만들기
```java
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        print(getClass(), "preHandle");
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        print(getClass(), "postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        print(getClass(), "afterCompletion");
    }
}
```

```java
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        print(getClass(), "preHandle");
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        print(getClass(), "postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        print(getClass(), "afterCompletion");
    }
}
```

## 인터셉터 설정
```java
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration logInterceptorRegistration = registry.addInterceptor(new LogInterceptor());
        logInterceptorRegistration.order(1);
        logInterceptorRegistration.addPathPatterns("/**");

        InterceptorRegistration authInterceptorRegistration = registry.addInterceptor(new AuthInterceptor());
        authInterceptorRegistration.order(2);
        authInterceptorRegistration.addPathPatterns("/**");
        authInterceptorRegistration.excludePathPatterns("/", "/login", "/logout", "*.ico");
    }
}
```
