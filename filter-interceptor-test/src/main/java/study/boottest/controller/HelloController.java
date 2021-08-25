package study.boottest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static study.boottest.utils.Util.print;

@Slf4j
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
    
    @ExceptionHandler
    public void handleEx(RuntimeException ex) {
        print(getClass(), "handleEx " + ex);
    }
}
