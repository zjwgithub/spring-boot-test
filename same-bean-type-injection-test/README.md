HelloServiceTest.java
```java
@SpringBootTest
class HelloServiceTest {

    @Autowired
    @Qualifier("helloServiceA") // HERE
    HelloService helloServiceV1;
    
    @Autowired
    @Qualifier("helloServiceB") // HERE
    HelloService helloServiceV2;

    @Test
    void name() {
        helloServiceV1.hello();
        helloServiceV2.hello();

        // console
        // HelloServiceImplV1.hello
        // HelloServiceImplV2.hello
    }
}
```

tree
```bash
service
└── impl
    ├── HelloService.java
    ├── v1
    │   └── HelloServiceImpl.java
    └── v2
        └── HelloServiceImpl.java
```

HelloService.java
```java
package service.impl;

public interface HelloService {
    
    void hello();
}
```

v1 HelloServiceImpl.java
```java
package service.impl.v1;

@Service("helloServiceA") // HERE
public class HelloServiceImpl implements HelloService {
    
    @Override
    public void hello() {
        System.out.println("HelloServiceImplV1.hello");
    }
}
```

v2 HelloServiceImpl.java
```java
package service.impl.v2;

@Service("helloServiceB") // HERE
public class HelloServiceImpl implements HelloService {
    
    @Override
    public void hello() {
        System.out.println("HelloServiceImplV2.hello");
    }
}
```
