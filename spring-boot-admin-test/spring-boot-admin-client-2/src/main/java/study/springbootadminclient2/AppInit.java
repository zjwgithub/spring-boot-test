package study.springbootadminclient2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppInit implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.trace("---trace msg");
        log.debug("---debug msg");
        log.info("---info msg");
        log.warn("---warn msg");
        log.error("---error msg");
    }
}
