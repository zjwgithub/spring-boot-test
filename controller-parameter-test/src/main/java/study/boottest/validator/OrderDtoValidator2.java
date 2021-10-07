package study.boottest.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import study.boottest.dto.OrderDto2;

@Component
public class OrderDtoValidator2 implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return OrderDto2.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDto2 orderDto2 = (OrderDto2) target;
        BindingResult bindingResult = (BindingResult) errors;

        if (orderDto2.getPrice() != null && orderDto2.getQuantity() != null) {
            if (orderDto2.getPrice() * orderDto2.getQuantity() > 10000) {
                bindingResult.reject("주문금액초과 10000");
            }
        }
    }
}
