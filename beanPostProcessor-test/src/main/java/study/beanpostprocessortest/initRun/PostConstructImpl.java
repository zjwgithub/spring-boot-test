package study.beanpostprocessortest.initRun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class PostConstructImpl {

    @PostConstruct
    public void run() {
        System.out.println();
        log.info("## PostConstructImpl.run()");
    }
}
