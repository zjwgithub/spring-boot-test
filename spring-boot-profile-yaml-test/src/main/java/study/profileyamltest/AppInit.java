package study.profileyamltest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@Profile("local")
public class AppInit {

    @Value("${my.server.desc}")
    private String myServerDesc;

    @Value("${my.server.host}")
    private String myServerHost;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println();
            System.out.println("myServerDesc = " + myServerDesc);
            System.out.println("myServerHost = " + myServerHost);
        };
    }
}
