package study.boottest.controller.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/validation-param")
public class ValidationParamController {

    @GetMapping
    public String getForm(@ModelAttribute ValidParamForm validParamForm, BindingResult bindingResult) {
        log.info("getForm");
        if (bindingResult.hasErrors()) {
            log.info("bindingResult = " + bindingResult);
            return "fail";
        }
        return "ok";
    }

    @PostMapping
    public String postForm(@Validated @ModelAttribute ValidParamForm validParamForm, BindingResult bindingResult) {
        log.info("postForm");
        if (bindingResult.hasErrors()) {
            log.info("bindingResult = " + bindingResult);
            return "fail";
        }
        log.info("validParamForm={}", validParamForm);
        return "ok";
    }
}
