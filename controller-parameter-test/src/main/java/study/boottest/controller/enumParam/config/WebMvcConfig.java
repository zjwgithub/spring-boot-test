package study.boottest.controller.enumParam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.controller.enumParam.converter.SearchTypeCodeConverter;
import study.boottest.controller.enumParam.converter.SearchTypeConverter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SearchTypeConverter());
        registry.addConverter(new SearchTypeCodeConverter());
    }
}
