package study.boottest.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static study.boottest.utils.Util.print;

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        DispatcherType dispatcherType = request.getDispatcherType();
        print(getClass(), "preHandle, " + dispatcherType + " " + method + " " + requestURI);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        DispatcherType dispatcherType = request.getDispatcherType();
        print(getClass(), "postHandle, " + dispatcherType + " " + method + " " + requestURI);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        DispatcherType dispatcherType = request.getDispatcherType();
        print(getClass(), "afterCompletion, " + dispatcherType + " " + method + " " + requestURI);
    }
}
