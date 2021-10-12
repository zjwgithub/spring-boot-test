package study.boottest.controller.param_test.basic.param;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ExtendParam extends Address {
    
    private String username;
    private Integer age;
}
