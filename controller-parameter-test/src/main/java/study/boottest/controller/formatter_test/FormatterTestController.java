package study.boottest.controller.formatter_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formatter")
public class FormatterTestController {

    @GetMapping
    public String test(Integer number) {
        System.out.println("number = " + number);
        return "ok";
    }
}
