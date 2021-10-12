package study.boottest.controller.enum_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.enum_test.enumType.SearchType;

@RestController
@RequestMapping("/enumtest")
public class EnumStringParamController {

    @GetMapping("/enum-string")
    public String receiveEnum(@RequestParam SearchType searchType) {
        System.out.println("searchType = " + searchType);
        return "ok: " + searchType;
    }
}
