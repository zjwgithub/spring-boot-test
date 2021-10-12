package study.boottest.controller.param_test.validation.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ValidateParam {
    
    @NotBlank
    private String username;
    
    @NotNull
    private Integer age;
}
