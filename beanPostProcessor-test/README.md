
```java
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
@Component
public class BeanPostProcessorConfig implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        log.info("before beanName={} bean={}", beanName, bean);
//        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        log.info("after  beanName={} bean={}", beanName, bean);
//        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        return bean;
    }
}
```
