package study.boottest.controller.enumParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.enumParam.type.SearchType;

@RestController
@RequestMapping("/enumtest")
public class StringParamController {

    @GetMapping("/string")
    public String receiveString(@RequestParam String searchType) {
        System.out.println("searchType = " + searchType);
        return "ok: " + searchType;
    }
}
