package study.boottest.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.boottest.filter.AuthFilter;
import study.boottest.filter.LogFilter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

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
