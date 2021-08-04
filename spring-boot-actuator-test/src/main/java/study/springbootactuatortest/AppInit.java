package study.springbootactuatortest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppInit implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            Thread.sleep(1000);
            System.out.println();
            log.trace("---trace message");
            log.debug("---debug message");
            log.info("---info message");
            log.warn("---warn message");
            log.error("---error message");
        }
    }
}
