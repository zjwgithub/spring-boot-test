package study.boottest.controller.param_test.param;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class ExtendsParam extends Address {
    
    private String username;
    private Integer age;
}
