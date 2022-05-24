package study.beannametest.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
@Component
public class MyPostConstruct {

    private final ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        log.info("MyPostConstruct.init");
        log.info("applicationContext={}", applicationContext);
    }
}
