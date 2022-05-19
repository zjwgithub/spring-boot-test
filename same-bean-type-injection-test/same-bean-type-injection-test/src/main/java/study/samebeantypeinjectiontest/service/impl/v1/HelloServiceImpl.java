package study.samebeantypeinjectiontest.service.impl.v1;

import org.springframework.stereotype.Service;
import study.samebeantypeinjectiontest.service.impl.HelloService;

@Service("helloServiceA")
public class HelloServiceImpl implements HelloService {
    
    @Override
    public void hello() {
        System.out.println("HelloServiceImplV1.hello");
    }
}
