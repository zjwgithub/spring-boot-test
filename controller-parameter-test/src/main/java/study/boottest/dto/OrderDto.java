package study.boottest.dto;

import lombok.Data;

@Data
public class OrderDto {
    
    private String itemName;
    private Integer quantity;
    private Integer price;
}
