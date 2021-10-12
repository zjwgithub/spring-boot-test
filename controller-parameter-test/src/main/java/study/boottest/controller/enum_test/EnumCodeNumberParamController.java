package study.boottest.controller.enum_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.enum_test.enumType.SearchCodeNumberType;
import study.boottest.controller.enum_test.enumType.SearchCodeStringType;

@RestController
@RequestMapping("/enumtest")
public class EnumCodeNumberParamController {

    @GetMapping("/enum-code-number")
    public String receiveEnum(@RequestParam SearchCodeNumberType searchType) {
        System.out.println("searchType = " + searchType);
        return "ok: " + searchType;
    }
}
