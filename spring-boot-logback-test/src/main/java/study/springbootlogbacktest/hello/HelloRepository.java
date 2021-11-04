package study.springbootlogbacktest.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class HelloRepository {

    public void hello() {
        log.debug("HelloRepository debug");
        log.info("HelloRepository info");
    }
}
