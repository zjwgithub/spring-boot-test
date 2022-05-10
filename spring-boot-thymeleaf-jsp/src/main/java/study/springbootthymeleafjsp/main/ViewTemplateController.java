package study.springbootthymeleafjsp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTemplateController {

    @GetMapping("/view-jsp")
    public String jspView() {
        return "items/item";
    }

    @GetMapping("/view-thymeleaf")
    public String thymeleafView() {
        return "thymeleaf/members/member";
    }

}
