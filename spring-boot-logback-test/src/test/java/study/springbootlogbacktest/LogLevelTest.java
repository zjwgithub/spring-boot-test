package study.springbootlogbacktest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Slf4j
public class LogLevelTest {

    @Test
    void trace() {
        log.trace("message 1");
        log.trace("message 2 {}", "aa");
        log.trace("message 3 {} {}", "aa", "bb");
        log.trace("message 4 {} {}", "aa");
        log.trace("message 5 {}", "aa", "bb");
    }

    @Test
    void debug() {
        log.debug("message 1");
        log.debug("message 2 {}", "aa");
        log.debug("message 3 {} {}", "aa", "bb");
        log.debug("message 4 {} {}", "aa");
        log.debug("message 5 {}", "aa", "bb");
    }

    @Test
    void info() {
        log.info("message 1");
        log.info("message 2 {}", "aa");
        log.info("message 3 {} {}", "aa", "bb");
        log.info("message 4 {} {}", "aa");
        log.info("message 5 {}", "aa", "bb");
    }

    @Test
    void warn() {
        log.warn("message 1");
        log.warn("message 2 {}", "aa");
        log.warn("message 3 {} {}", "aa", "bb");
        log.warn("message 4 {} {}", "aa");
        log.warn("message 5 {}", "aa", "bb");
    }

    @Test
    void error() {
        try {
            try {
                Optional.of(null);
            } catch (Exception e) {
                throw new RuntimeException("에러가 발생함!!", e);
            }
        } catch (Exception e) {
            log.error("message 1");
            log.error("message 11", e);
            log.error("message 2 {}", "aa", e);
            log.error("message 3 {} {}", "aa", "bb", e);
            log.error("message 4 {} {}", "aa", e);
            log.error("message 5 {}", "aa", "bb", e);
        }
    }
}
