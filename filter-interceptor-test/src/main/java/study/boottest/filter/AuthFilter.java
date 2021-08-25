package study.boottest.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static study.boottest.utils.Util.print;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String method = httpRequest.getMethod();
        String requestURI = httpRequest.getRequestURI();
        DispatcherType dispatcherType = httpRequest.getDispatcherType();

        try {
            print(getClass(), "doFilter 시작, " + dispatcherType + " " + method + " " + requestURI);
            chain.doFilter(request, response);
        } catch (Exception e) {
            print(getClass(), "doFilter 에러, " + e);
            throw e;
        } finally {
            print(getClass(), "doFilter 종료, " + dispatcherType + " " + method + " " + requestURI);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        print(getClass(), "init");
    }

    @Override
    public void destroy() {
        print(getClass(), "destroy");
    }
}
