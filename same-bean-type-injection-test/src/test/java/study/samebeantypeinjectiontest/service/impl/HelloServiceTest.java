package study.samebeantypeinjectiontest.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    @Qualifier("helloServiceA")
    HelloService helloServiceV1;
    
    @Autowired
    @Qualifier("helloServiceB")
    HelloService helloServiceV2;

    @Test
    void name() {
        helloServiceV1.hello();
        helloServiceV2.hello();
    }
}