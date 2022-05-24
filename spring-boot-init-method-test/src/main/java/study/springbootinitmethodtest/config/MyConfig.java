package study.springbootinitmethodtest.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springbootinitmethodtest.beanPostProcessor.MyBeanPostProcessor;

@Configuration
public class MyConfig {

    @Bean
    public BeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
