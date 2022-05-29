package study.boottest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static study.boottest.utils.Util.print;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        print(getClass(), "시작");
        helloService.hello();
        print(getClass(), "종료");
        return "ok";
    }

    @GetMapping("/ex")
    public String ex() {
        print(getClass(), "RuntimeException 예외 발생");
        throw new RuntimeException("RuntimeException 예외 발생");
    }

    @GetMapping("/ex-with-handler")
    public String exWithHandler() {
        print(getClass(), "IllegalStateException 예외 발생");
        throw new IllegalStateException("IllegalStateException 예외 발생");
    }
    
    @ExceptionHandler
    public void handleEx(IllegalStateException ex) {
        print(getClass(), "IllegalStateException 예외 핸들링");
    }
}
