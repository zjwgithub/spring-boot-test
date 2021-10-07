package study.boottest.controller.order;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.dto.OrderDto;

import java.util.List;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;
import static study.boottest.utils.Util.printBindingResult;

@RestController
@RequestMapping("/order/v1")
public class OrderControllerV1 {

    @GetMapping
    public String getItems(OrderDto orderDto, BindingResult bindingResult) {

        rejectIfEmptyOrWhitespace(bindingResult, "itemName", "required");
        rejectIfEmpty(bindingResult, "price", "required");
        if (bindingResult.hasFieldErrors("quantity") == false && orderDto.getQuantity() == null) {
            bindingResult.rejectValue("quantity", "required");
        }
        if (orderDto.getPrice() != null && orderDto.getQuantity() != null) {
            if (orderDto.getPrice() * orderDto.getQuantity() > 10000) {
                bindingResult.reject("주문금액초과 10000");
            }
        }
        
        if (bindingResult.hasErrors()) {
            printBindingResult(bindingResult);
            return "validtation fail";
        }
        return "validtation ok";
    }
}
