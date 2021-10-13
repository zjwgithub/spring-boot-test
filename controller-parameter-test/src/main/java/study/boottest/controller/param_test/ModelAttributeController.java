package study.boottest.controller.param_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.boottest.controller.param_test.param.MemberParam;

@Slf4j
@RestController
@RequestMapping("/model-param")
public class ModelAttributeController {
    
    @GetMapping
    public String getModel(@ModelAttribute MemberParam memberParam) {
        System.out.println("ModelAttributeController.getModel");
        log.info("memberParam={}" + memberParam);
        return "GET OK, " + memberParam;
    }

    @PostMapping
    public String postModel(@ModelAttribute MemberParam memberParam) {
        System.out.println("ModelAttributeController.postModel");
        log.info("memberParam={}" + memberParam);
        return "POST OK, " + memberParam;
    }

}
