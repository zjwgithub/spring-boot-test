package study.boottest.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/a")
public class ApiControllerA {
    
    @GetMapping("/error-ex")
    public String errorEx() throws Exception {
        throw new Exception("Exception 발생");
    }

    @GetMapping("/error-rex")
    public String errorREx() {
        throw new RuntimeException("RuntimeException 발생");
    }

}
