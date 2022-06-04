package study.importimportresourcetest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.importimportresourcetest.service.ItemService;
import study.importimportresourcetest.service.MemberService;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/members")
    public String members() {
        return memberService.hello();
    }

    @GetMapping("/items")
    public String items() {
        return itemService.hello();
    }
}
