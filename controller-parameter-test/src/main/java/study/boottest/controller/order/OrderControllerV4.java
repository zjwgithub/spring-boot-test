package study.boottest.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.boottest.dto.OrderDto;
import study.boottest.dto.OrderDto2;
import study.boottest.validator.OrderDtoValidator;

import static study.boottest.utils.Util.printBindingResult;

@RestController
@RequestMapping("/order/v4")
@RequiredArgsConstructor
public class OrderControllerV4 {
    
    @GetMapping
    public String getItems(@Validated OrderDto2 orderDto2, BindingResult bindingResult) {

        if (orderDto2.getPrice() != null && orderDto2.getQuantity() != null) {
            if (orderDto2.getPrice() * orderDto2.getQuantity() > 10000) {
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
