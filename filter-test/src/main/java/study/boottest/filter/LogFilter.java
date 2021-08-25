package study.boottest.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static study.boottest.utils.Util.print;

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
