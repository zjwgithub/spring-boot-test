package study.springbootlogbacktest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import study.springbootlogbacktest.logging.MyRepository;
import study.springbootlogbacktest.logging.MyService;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppInit implements CommandLineRunner {

    private final MyService myService;
    private final MyRepository myRepository;

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            logTest();
            Thread.sleep(5000);
        }
    }

    private void logTest() {
        System.out.println();
        System.out.println("AppInit");

        log.trace("trace message 1");
        log.trace("trace message 2 {}", "aa");
        log.trace("trace message 3 {} {}", "aa", "bb");
        log.trace("trace message 4 {} {}", "aa", "bb", "cc");
        log.trace("trace message 5 {} {}", "aa");

        log.debug("debug message 1");
        log.debug("debug message 2 {}", "aa");
        log.debug("debug message 3 {} {}", "aa", "bb");
        log.debug("debug message 4 {} {}", "aa", "bb", "cc");
        log.debug("debug message 5 {} {}", "aa");

        log.info("info message 1");
        log.info("info message 2 {}", "aa");
        log.info("info message 3 {} {} ", "aa", "bb");
        log.info("info message 4 {} {} ", "aa", "bb", "cc");
        log.info("info message 5 {} {} ", "aa");

        log.warn("warn message 1");
        log.warn("warn message 2 {}", "aa");
        log.warn("warn message 3 {} {} ", "aa", "bb");
        log.warn("warn message 4 {} {} ", "aa", "bb", "cc");
        log.warn("warn message 5 {} {} ", "aa");

        try {
            throw new RuntimeException("exception occured");
        } catch (Exception e) {
            log.error("error message 1");
            log.error("error message 2", e);
            log.error("error message 3 {}", "aa", e);
            log.error("error message 4 {} {}", "aa", "bb", e);
            log.error("error message 5 {} {}", "aa", "bb", "cc", e);
            log.error("error message 6 {} {}", "aa", e);
        }

        myService.hello();
        myRepository.hello();
    }

}
