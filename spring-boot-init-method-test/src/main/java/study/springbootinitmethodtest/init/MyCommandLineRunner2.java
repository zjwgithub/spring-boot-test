package study.springbootinitmethodtest.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner2 {

    @Bean
    public CommandLineRunner run() {
        return args -> {
            System.out.println();
            System.out.println("MyCommandLineRunner2");
            System.out.println();
        };
    }
}
