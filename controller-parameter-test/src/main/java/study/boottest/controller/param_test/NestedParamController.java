package study.boottest.controller.param_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.boottest.controller.param_test.param.NestedParam;

@Slf4j
@RestController
@RequestMapping("/nested-param")
public class NestedParamController {
    
    @GetMapping
    public String getNestedParam(@ModelAttribute NestedParam nestedParam) {
        System.out.println("NestedParamController.getNestedParam");
        log.info("nestedParam={}", nestedParam);
        return "GET OK, " + nestedParam;
    }

    @PostMapping
    public String postNestedParam(@ModelAttribute NestedParam nestedParam) {
        System.out.println("NestedParamController.postNestedParam");
        log.info("nestedParam={}", nestedParam);
        return "POST OK, " + nestedParam;
    }
}
