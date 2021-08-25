package study.boottest.controller.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BasicParamController {
    
    @GetMapping("/basic-param")
    public String getParam(@RequestParam String username, @RequestParam String age) {
        log.info("username={}, age={}", username, age);
        return "GET RequestParam OK, " + username + ", " + age;
    }

    @PostMapping("/basic-param")
    public String postParam(@RequestParam String username, @RequestParam String age) {
        log.info("username={}, age={}", username, age);
        return "POST RequestParam OK, " + username + ", " + age;
    }

    @GetMapping("/basic-param/model")
    public String getModel(@ModelAttribute BasicParamForm basicParamForm) {
        log.info("basicParamForm={}" + basicParamForm);
        return "GET ModelAttribute OK, " + basicParamForm;
    }

    @PostMapping("/basic-param/model")
    public String postModel(@ModelAttribute BasicParamForm basicParamForm) {
        log.info("basicParamForm={}" + basicParamForm);
        return "POST ModelAttribute OK, " + basicParamForm;
    }

    @GetMapping("/basic-param/path/{username}/{age}")
    public String getPath(@PathVariable String username, @PathVariable String age) {
        log.info("username={}, age={}", username, age);
        return "GET PathVariable OK, " + username + ", " + age;
    }

    @PostMapping("/basic-param/path/{username}/{age}")
    public String postPath(@PathVariable String username, @PathVariable String age) {
        log.info("username={}, age={}", username, age);
        return "POST PathVariable OK, " + username + ", " + age;
    }
}
