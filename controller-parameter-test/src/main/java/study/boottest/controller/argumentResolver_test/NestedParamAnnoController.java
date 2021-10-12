package study.boottest.controller.argumentResolver_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.boottest.controller.argumentResolver_test.annotation.NestedParamAnno;
import study.boottest.controller.argumentResolver_test.param.NestedParam;

@Slf4j
@RestController
@RequestMapping("/nested-param-anno")
public class NestedParamAnnoController {
    
    @GetMapping
    public String getNestedParam(@NestedParamAnno NestedParam nestedParam) {
        System.out.println("NestedParamController.getNestedParam");
        log.info("nestedParam={}", nestedParam);
        return "GET OK, " + nestedParam;
    }

    @PostMapping
    public String postNestedParam(@NestedParamAnno NestedParam nestedParam) {
        System.out.println("NestedParamController.postNestedParam");
        log.info("nestedParam={}", nestedParam);
        return "POST OK, " + nestedParam;
    }
}
