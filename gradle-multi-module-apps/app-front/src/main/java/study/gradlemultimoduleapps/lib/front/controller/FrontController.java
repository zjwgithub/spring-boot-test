package study.gradlemultimoduleapps.lib.front.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.gradlemultimoduleapps.lib.util.LibUtil;

@RestController
public class FrontController {

    @GetMapping("/front")
    public String home() {
        return "hello front, " + LibUtil.getText();
    }
}
