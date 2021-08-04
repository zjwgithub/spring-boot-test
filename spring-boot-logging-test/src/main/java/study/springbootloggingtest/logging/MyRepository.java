package study.springbootloggingtest.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class MyRepository {

    public void hello() {
        log.info("hello repository");
    }
}
