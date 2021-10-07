package study.boottest.controller.param.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/validate-param")
public class ValidateParamController {

    @GetMapping
    public String getModel(@Validated ValidateParam validateParam, BindingResult bindingResult) {
        System.out.println("ValidateParamController.getModel");
        log.info("bindingResult.hasErrors() = " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            log.info("bindingResult.getErrorCount() = " + bindingResult.getErrorCount());
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println("  - allError = " + allError);
            }
            return "fail";
        }
        log.info("validateParam={}", validateParam);
        return "ok";
    }

    @PostMapping
    public String postModel(@Validated ValidateParam validateParam, BindingResult bindingResult) {
        System.out.println("ValidateParamController.postModel");
        log.info("bindingResult.hasErrors() = " + bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            log.info("bindingResult.getErrorCount() = " + bindingResult.getErrorCount());
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println("  - allError = " + allError);
            }
            return "fail";
        }
        log.info("validateParam={}", validateParam);
        return "ok";
    }
}
