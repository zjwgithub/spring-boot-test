package study.boottest.controller.param_test.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.boottest.controller.param_test.basic.param.ExtendParam;

@Slf4j
@RestController
@RequestMapping("/extend-param")
public class ExtendParamController {
    
    @GetMapping
    public String getExtendParam(@ModelAttribute ExtendParam extendParam) {
        System.out.println("ExtendParamController.getExtendParam");
        log.info("extendParam={}", extendParam);
        return "GET OK, " + extendParam;
    }

    @PostMapping
    public String postExtendParam(@ModelAttribute ExtendParam extendParam) {
        System.out.println("ExtendParamController.postExtendParam");
        log.info("extendParam={}", extendParam);
        return "POST OK, " + extendParam;
    }
}
