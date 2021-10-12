package study.boottest.controller.param_test.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/basic-param")
public class BasicParamController {
    
    @GetMapping
    public String getParam(@RequestParam String username, @RequestParam String age) {
        System.out.println("BasicParamController.getParam");
        log.info("username={}, age={}", username, age);
        return "GET RequestParam OK, " + username + ", " + age;
    }

    @PostMapping
    public String postParam(@RequestParam String username, @RequestParam String age) {
        System.out.println("BasicParamController.postParam");
        log.info("username={}, age={}", username, age);
        return "POST RequestParam OK, " + username + ", " + age;
    }

    @GetMapping("/model")
    public String getModel(@ModelAttribute BasicParam basicParam) {
        System.out.println("BasicParamController.getModel");
        log.info("basicParam={}" + basicParam);
        return "GET ModelAttribute OK, " + basicParam;
    }

    @PostMapping("/model")
    public String postModel(@ModelAttribute BasicParam basicParam) {
        System.out.println("BasicParamController.postModel");
        log.info("basicParam={}" + basicParam);
        return "POST ModelAttribute OK, " + basicParam;
    }

    @GetMapping("/path/{username}/{age}")
    public String getPath(@PathVariable String username, @PathVariable String age) {
        System.out.println("BasicParamController.getPath");
        log.info("username={}, age={}", username, age);
        return "GET PathVariable OK, " + username + ", " + age;
    }

    @PostMapping("/path/{username}/{age}")
    public String postPath(@PathVariable String username, @PathVariable String age) {
        System.out.println("BasicParamController.postPath");
        log.info("username={}, age={}", username, age);
        return "POST PathVariable OK, " + username + ", " + age;
    }
}
