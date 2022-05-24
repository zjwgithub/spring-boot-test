package study.beannametest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.beannametest.app.ServiceA;
import study.beannametest.app.ServiceB;
import study.beannametest.app.ServiceC;

@Configuration
public class MyConfig {

    @Bean
    public ServiceA serviceA() {
        return new ServiceA();
    }

    @Bean
    public ServiceB myServiceB() {
        return new ServiceB();
    }

    @Bean("my_ServiceC")
    public ServiceC myServiceC() {
        return new ServiceC();
    }
}
