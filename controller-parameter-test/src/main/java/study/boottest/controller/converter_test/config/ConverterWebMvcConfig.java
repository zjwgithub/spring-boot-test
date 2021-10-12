package study.boottest.controller.converter_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.controller.converter_test.converter.StringToIntegerConverter;

@Configuration
public class WebMvcConfig2 implements WebMvcConfigurer {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
    }
}
