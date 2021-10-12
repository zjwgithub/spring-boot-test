package study.boottest.controller.argumentResolver_test.argumentResolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import study.boottest.controller.argumentResolver_test.annotation.NestedParamAnno;
import study.boottest.controller.argumentResolver_test.param.Address;
import study.boottest.controller.argumentResolver_test.param.NestedParam;

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

        ModelAttributeMethodProcessor modelAttributeMethodProcessor1 = new ModelAttributeMethodProcessor(false);
        modelAttributeMethodProcessor1.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        NestedParam nestedParam1 = (NestedParam) modelAttributeMethodProcessor1.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        System.out.println("nestedParam1 = " + nestedParam1);

//        RequestParamMapMethodArgumentResolver requestParamMapMethodArgumentResolver = new RequestParamMapMethodArgumentResolver();
//        Object object = requestParamMapMethodArgumentResolver.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
//        System.out.println("object = " + object);
//        NestedParam nestedParam1 = (NestedParam) object;
//        System.out.println("nestedParam1 = " + nestedParam1);

        String city = webRequest.getParameter("city");
        String street = webRequest.getParameter("street");
        String zipcode = webRequest.getParameter("zipcode");
        Address address = new Address(city, street, zipcode);
        
        NestedParam nestedParam = new NestedParam();
        nestedParam.setUsername(webRequest.getParameter("username"));
        nestedParam.setAge(Integer.valueOf(webRequest.getParameter("age")));
        nestedParam.setAddress(address);
        return nestedParam;
    }
}
