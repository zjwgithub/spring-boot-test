package study.boottest.controller.argumentResolver_test.argumentResolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import study.boottest.controller.argumentResolver_test.annotation.NestedParamAnno;
import study.boottest.controller.argumentResolver_test.param.Address;
import study.boottest.controller.argumentResolver_test.param.NestedParam;

import static study.boottest.utils.ReflectionUtil.fillDtoFromNativeWebRequest;

@Slf4j
public class NestedParamArgumentResolver implements HandlerMethodArgumentResolver {
    
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println("NestedParamArgumentReHandlerMethodArgumentResolversolver.supportsParameter");
//        boolean support = parameter.getParameterType().equals(NestedParam.class);
        boolean support = parameter.hasParameterAnnotation(NestedParamAnno.class);
        return support;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        System.out.println("NestedParamArgumentResolver.resolveArgument");

        NestedParam nestedParam = new NestedParam();
        fillDtoFromNativeWebRequest(nestedParam, webRequest);

        Address address = new Address(
                webRequest.getParameter("city"), 
                webRequest.getParameter("street"), 
                webRequest.getParameter("zipcode"));
        nestedParam.setAddress(address);

        System.out.println("nestedParam = " + nestedParam);
        
        return nestedParam;
    }
}
