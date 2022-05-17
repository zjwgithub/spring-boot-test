package study.gradlemultimoduleapps.lib.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.gradlemultimoduleapps.lib.util.LibUtil;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String home() {
        return "hello admin, " + LibUtil.getText();
    }
}
