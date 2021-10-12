package study.boottest.controller.converter_test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/converter")
public class ConverterTestController {
    
    @GetMapping("string-to-integer")
    public String test1(Integer num) {
        System.out.println("num = " + num);
        return "ok";
    }

    @GetMapping("integer-to-string")
    public String test2(String num) {
        System.out.println("num = " + num);
        return "ok";
    }
}
