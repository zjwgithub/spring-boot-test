package study.boottest.controller.enum_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.enum_test.enumType.SearchCodeStringType;

@RestController
@RequestMapping("/enumtest")
public class EnumCodeStringParamController {

    @GetMapping("/enum-code-string")
    public String receiveEnum(@RequestParam SearchCodeStringType searchType) {
        System.out.println("searchType = " + searchType);
        return "ok: " + searchType;
    }
}
