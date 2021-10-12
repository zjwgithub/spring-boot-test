package study.boottest.controller.validator_test;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.controller.validator_test.dto.OrderDto;
import study.boottest.controller.validator_test.validator.OrderDtoValidator;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;
import static study.boottest.utils.Util.printBindingResult;

@RestController
@RequestMapping("/order/v2")
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderDtoValidator orderDtoValidator;

    @GetMapping
    public String getItems(OrderDto orderDto, BindingResult bindingResult) {
        
        orderDtoValidator.validate(orderDto, bindingResult);

        if (bindingResult.hasErrors()) {
            printBindingResult(bindingResult);
            return "validtation fail";
        }
        return "validtation ok";
    }
}
