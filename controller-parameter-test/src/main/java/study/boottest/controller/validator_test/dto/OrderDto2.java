package study.boottest.controller.validator_test.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OrderDto2 {
    
    @NotBlank
    private String itemName;
    
    @NotNull
    private Integer quantity;
    
    @NotNull
    private Integer price;
}
