package study.boottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static study.boottest.utils.Util.print;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        print(getClass(), "hello");
        return "ok";
    }

    @GetMapping("/ex")
    public String raiseEx() {
        throw new RuntimeException("raiseEx 발생");
    }
}
