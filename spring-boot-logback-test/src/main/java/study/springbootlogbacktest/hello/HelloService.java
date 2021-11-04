package study.springbootlogbacktest.hello;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public void hello() {
        log.debug("HelloService debug");
        log.info("HelloService info");
        helloRepository.hello();
    }
}
