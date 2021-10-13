package study.boottest.controller.converter_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.boottest.controller.converter_test.converter.IpPortToStringConverter;
import study.boottest.controller.converter_test.converter.StringToIntegerConverter;
import study.boottest.controller.converter_test.converter.StringToIpPortConverter;

@Configuration
public class ConverterConfig implements WebMvcConfigurer {
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
    }
}
