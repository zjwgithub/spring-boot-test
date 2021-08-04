package study.profileyamltest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class ProfileTest {

    @Value("${my.server.desc}")
    private String myServerDesc;

    @Value("${my.server.host}")
    private String myServerHost;

    @Test
    void test() {
        System.out.println("myServerDesc = " + myServerDesc);
        System.out.println("myServerHost = " + myServerHost);
    }
}
