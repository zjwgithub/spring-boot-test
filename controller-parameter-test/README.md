- ### OrderController
    ```java
    @RestController
    @RequestMapping("/orders")
    @RequiredArgsConstructor
    public class OrderController {
        
        private final OrderDtoValidator orderDtoValidator;
    
        @InitBinder
        public void initDataBinder(WebDataBinder webDataBinder) {
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
    ```

- ### OrderDtoValidator
    ```java
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
    
            if (orderDto.getPrice() != null && orderDto.getQuantity() != null) {
                if (orderDto.getPrice() * orderDto.getQuantity() > 10000) {
                    bindingResult.reject("주문금액초과");
                }
            }
        }
    }
    ```

- ### OrderDto
    ```java
    @Data
    public class OrderDto {
        
        @NotBlank
        private String itemName;
        
        @NotNull
        private Integer quantity;
        
        @NotNull
        private Integer price;
    }
    ```