package study.springbootloggingtest.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {

    public void hello() {
        log.info("hello service");
    }
}
