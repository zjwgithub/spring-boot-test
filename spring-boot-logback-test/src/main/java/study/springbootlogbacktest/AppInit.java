package study.springbootlogbacktest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import study.springbootlogbacktest.hello.HelloController;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppInit implements CommandLineRunner {

    private final HelloController helloController;

    @Override
    public void run(String... args) throws Exception {
       logTest();
    }

    private void logTest() {
        System.out.println();
        System.out.println("AppInit");

        helloController.hello();
    }

}
