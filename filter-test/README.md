## Fileter 만들기

### LogFilter
```java
import javax.servlet.Filter;

@Slf4j
public class LogFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
        print(getClass(), "init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter");
        print(getClass(), "doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String method = httpRequest.getMethod();
        String requestURI = httpRequest.getRequestURI();
        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println();
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy");
        print(getClass(), "destroy");
    }
}
```

### AuthFilter
```java
import javax.servlet.Filter;

@Slf4j
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
        print(getClass(), "init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter");
        print(getClass(), "doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String method = httpRequest.getMethod();
        String requestURI = httpRequest.getRequestURI();
        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println();

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy");
        print(getClass(), "destroy");
    }
}
```

## Fileter config 만들기
```java
@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ERROR);
        return filterRegistrationBean;
    }
    
    @Bean
    public FilterRegistrationBean authFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistrationBean;
    }
}
```