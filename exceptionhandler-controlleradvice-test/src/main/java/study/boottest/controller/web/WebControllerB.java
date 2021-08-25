package study.boottest.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/b")
public class WebControllerB {

    @GetMapping("/error-ex")
    public String errorEx() throws Exception {
        throw new Exception("Exception 발생");
    }

    @GetMapping("/error-rex")
    public String errorREx() {
        throw new RuntimeException("RuntimeException 발생");
    }
}
