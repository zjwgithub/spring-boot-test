package study.springbootlogbacktest.hello;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    @GetMapping
    public void hello() {
        System.out.println();
        log.debug("HelloController debug");
        log.info("HelloController info");
        helloService.hello();
    }

}
