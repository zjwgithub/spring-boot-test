package study.boottest.controller.enum_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.controller.enum_test.converter.SearchCodeNumberTypeConverter;
import study.boottest.controller.enum_test.converter.SearchCodeStringTypeConverter;
import study.boottest.controller.enum_test.converter.SearchTypeConverter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SearchTypeConverter()); // 대,소문자 구분없이 가능하도록
        registry.addConverter(new SearchCodeNumberTypeConverter());
        registry.addConverter(new SearchCodeStringTypeConverter());
    }
}
