package study.boottest.controller.enumParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.enumParam.type.SearchTypeCode;

@RestController
@RequestMapping("/enumtest")
public class EnumCodeParamController {

    @GetMapping("/code")
    public String receiveEnum(@RequestParam SearchTypeCode searchType) {
        System.out.println("searchType = " + searchType);
        return "ok: " + searchType;
    }
}
