package study.boottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.interceptor.AuthInterceptor;
import study.boottest.interceptor.LogInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
//                .excludePathPatterns("")
                ;

        registry.addInterceptor(new AuthInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/logout", "*.ico")
        ;
    }
}
