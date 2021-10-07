package study.boottest.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import study.boottest.dto.OrderDto;

import static org.springframework.validation.ValidationUtils.rejectIfEmpty;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

@Component
public class OrderDtoValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return OrderDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderDto orderDto = (OrderDto) target;
        BindingResult bindingResult = (BindingResult) errors;

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
    }
}
