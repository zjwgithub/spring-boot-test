package study.boottest.controller.param_test.basic.param;

import lombok.Data;

@Data
public class NestedParam {
    
    private String username;
    private Integer age;
    private Address address = new Address();

}
