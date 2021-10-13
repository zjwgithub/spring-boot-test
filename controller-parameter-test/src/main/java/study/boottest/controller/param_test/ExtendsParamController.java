package study.boottest.controller.param_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.boottest.controller.param_test.param.ExtendsParam;

@Slf4j
@RestController
@RequestMapping("/extend-param")
public class ExtendsParamController {
    
    @GetMapping
    public String getExtendParam(@ModelAttribute ExtendsParam extendsParam) {
        System.out.println("ExtendParamController.getExtendParam");
        log.info("extendParam={}", extendsParam);
        return "GET OK, " + extendsParam;
    }

    @PostMapping
    public String postExtendParam(@ModelAttribute ExtendsParam extendsParam) {
        System.out.println("ExtendParamController.postExtendParam");
        log.info("extendParam={}", extendsParam);
        return "POST OK, " + extendsParam;
    }
}
