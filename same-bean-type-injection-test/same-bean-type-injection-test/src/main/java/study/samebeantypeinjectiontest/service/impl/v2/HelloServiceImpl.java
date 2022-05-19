package study.samebeantypeinjectiontest.service.impl.v2;

import org.springframework.stereotype.Service;
import study.samebeantypeinjectiontest.service.impl.HelloService;

@Service("helloServiceB")
public class HelloServiceImpl implements HelloService {
    
    @Override
    public void hello() {
        System.out.println("HelloServiceImplV2.hello");
    }
}
