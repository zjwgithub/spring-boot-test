package study.boottest.dto;

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
