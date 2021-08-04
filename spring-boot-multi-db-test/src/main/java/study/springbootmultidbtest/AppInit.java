package study.springbootmultidbtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppInit {

    @Value("${my.conf1}")
    private String myConf1;

    @Value("${my.conf2}")
    private String myConf2;

    @Value("${my.db.config}")
    private String myDbConfig;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println();
            System.out.println("myConf1 = " + myConf1);
            System.out.println("myConf2 = " + myConf2);
            System.out.println("myDbConfig = " + myDbConfig);
            System.out.println("driverClassName = " + driverClassName);
            System.out.println("url = " + url);
            System.out.println();
        };
    }
}
