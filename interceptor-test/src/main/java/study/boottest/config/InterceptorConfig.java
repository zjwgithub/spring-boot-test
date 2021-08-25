package study.boottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.interceptor.AuthInterceptor;
import study.boottest.interceptor.LogInterceptor;

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
