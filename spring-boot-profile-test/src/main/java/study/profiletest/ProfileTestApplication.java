package study.profiletest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

//@Profile("prod")
@SpringBootApplication
public class ProfileTestApplication {

    @Value("${my.server.url}")
    private String myServerUrl;

    @Value("${my.server.port}")
    private int myServerPort;

    @Value("${my.noprofile.value.in.properties}")
    private String noProfileValueInProp;

    @Value("${my.noprofile.value.in.yml}")
    private String noProfileValueInYml;

    public static void main(String[] args) {
        SpringApplication.run(ProfileTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("myServerUrl = " + myServerUrl);
            System.out.println("myServerPort = " + myServerPort);
            System.out.println("noProfileValueInProp = " + noProfileValueInProp);
            System.out.println("noProfileValueInYml = " + noProfileValueInYml);
        };
    }

}
