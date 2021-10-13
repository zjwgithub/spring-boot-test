package study.boottest.controller.argumentResolver_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.controller.argumentResolver_test.argumentResolver.NestedParamArgumentResolver;

import java.util.List;

@Configuration
public class ArgumentResolverConfig implements WebMvcConfigurer {
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        System.out.println("ArgumentResolverWebMvcConfig.addArgumentResolvers");
        resolvers.add(new NestedParamArgumentResolver());
    }
}
