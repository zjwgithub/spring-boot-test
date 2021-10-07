package study.boottest.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.dto.OrderDto;
import study.boottest.validator.OrderDtoValidator;

import java.util.List;

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
