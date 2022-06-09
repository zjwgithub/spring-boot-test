package study.springbootcorstest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:8080"})
@Slf4j
@RestController
public class ItemController {

    @GetMapping("/items")
    public String items() {
        return "item list";
    }

//    @CrossOrigin("http://localhost:8080")
    @PostMapping("/items")
    public ResultDto addItems(@RequestBody ItemForm itemForm) {
        log.info("itemForm={}", itemForm);
        ResultDto resultDto = new ResultDto(true, "ok");
        log.info("resultDto={}", resultDto);
        return resultDto;
    }
}
