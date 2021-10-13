package study.boottest.controller.enum_test;

import org.springframework.web.bind.annotation.*;
import study.boottest.controller.enum_test.dto.BoardEnumDto;
import study.boottest.controller.enum_test.enumType.SearchCodeNumberType;

@RestController
@RequestMapping("/enumtest")
public class EnumModelParamController {

    @GetMapping("/enum-model")
    public String receiveEnum(BoardEnumDto boardEnumDto) {
        System.out.println("boardEnumDto = " + boardEnumDto);
        return "ok: " + boardEnumDto;
    }
}
