package study.boottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParamController {
    
    @GetMapping("/param")
    @ResponseBody
    public String getParam(String username, String age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "getParam OK, " + username + ", " + age;
    }

    @GetMapping("/param/model")
    @ResponseBody
    public String getParamModel(ParamForm paramForm) {
        System.out.println("paramForm = " + paramForm);
        return "getParamModel OK, " + paramForm;
    }

    @PostMapping("/param")
    @ResponseBody
    public String postParam(String username, String age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "postParam OK, " + username + ", " + age;
    }

    @PostMapping("/param/model")
    @ResponseBody
    public String postParamModel(ParamForm paramForm) {
        System.out.println("paramForm = " + paramForm);
        return "postParamModel OK, " + paramForm;
    }

    @GetMapping("/param/path/{username}/{age}")
    @ResponseBody
    public String getParamPath1(@PathVariable String username, @PathVariable String age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "getParamPath1 OK, " + username + ", " + age;
    }
}
