package study.boottest.controller.formatter_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.controller.formatter_test.formatter.MyNumberFormatter;

@Configuration
public class FormatterConfig implements WebMvcConfigurer {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MyNumberFormatter());
    }
}
