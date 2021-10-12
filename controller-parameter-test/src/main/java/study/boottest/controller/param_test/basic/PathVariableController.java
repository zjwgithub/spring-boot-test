package study.boottest.controller.param_test.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/path-param")
public class PathVariableController {
    
    @GetMapping("/{username}/{age}")
    public String getPath(@PathVariable String username, @PathVariable Integer age) {
        System.out.println("PathVariableController.getPath");
        log.info("username={}, age={}", username, age);
        return "GET OK, " + username + ", " + age;
    }

    @PostMapping("/{username}/{age}")
    public String postPath(@PathVariable String username, @PathVariable Integer age) {
        System.out.println("PathVariableController.postPath");
        log.info("username={}, age={}", username, age);
        return "POST OK, " + username + ", " + age;
    }
}
