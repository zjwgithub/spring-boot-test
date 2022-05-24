package study.springbootinitmethodtest.beanPostProcessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("before beanName={} bean={}", beanName, bean);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("after  beanName={} bean={}", beanName, bean);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
