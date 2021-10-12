package study.boottest.controller.param_test.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/request-param")
public class RequestParamController {
    
    @GetMapping
    public String getParam(@RequestParam String username, @RequestParam Integer age) {
        System.out.println("RequestParamController.getParam");
        log.info("username={}, age={}", username, age);
        return "GET OK, " + username + ", " + age;
    }

    @PostMapping
    public String postParam(@RequestParam String username, @RequestParam Integer age) {
        System.out.println("RequestParamController.postParam");
        log.info("username={}, age={}", username, age);
        return "POST OK, " + username + ", " + age;
    }
}
