package study.boottest.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.dto.OrderDto2;
import study.boottest.validator.OrderDtoValidator2;

import static study.boottest.utils.Util.printBindingResult;

@RestController
@RequestMapping("/order/v5")
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderDtoValidator2 orderDtoValidator2;
    
    @GetMapping
    public String getItems(@Validated OrderDto2 orderDto2, BindingResult bindingResult) {

        orderDtoValidator2.validate(orderDto2, bindingResult);
        
        if (bindingResult.hasErrors()) {
            printBindingResult(bindingResult);
            return "validtation fail";
        }
        return "validtation ok";
    }
}
