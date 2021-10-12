package study.boottest.controller.param_test.basic.param;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class ExtendParam extends Address {
    
    private String username;
    private Integer age;
}
