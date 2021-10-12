package study.boottest.controller.validator_test;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.validator_test.dto.OrderDto;
import study.boottest.controller.validator_test.validator.OrderDtoValidator;

import static study.boottest.utils.Util.printBindingResult;

@RestController
@RequestMapping("/order/v3")
@RequiredArgsConstructor
public class OrderControllerV3 {
    
    private final OrderDtoValidator orderDtoValidator;

    @InitBinder
    public void initDataBinder(WebDataBinder webDataBinder) {
        System.out.println("## OrderControllerV3.initDataBinder");
        webDataBinder.addValidators(orderDtoValidator);
    }

    @GetMapping
    public String getItems(@Validated OrderDto orderDto, BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            printBindingResult(bindingResult);
            return "validtation fail";
        }
        return "validtation ok";
    }
}
