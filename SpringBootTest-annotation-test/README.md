# `@SpringBootTest` 애노테이션 테스트

## Service 클래스를 2개 만든다
```java
@Service
public class MemberService {

    public String hello() {
        return "hello member";
    }
}
```
```java
@Service
public class ItemService {

    public String hello() {
        return "hello item";
    }
}
```

## ServiceTest1
- `@SpringBootTest` 를 옵션 없이 사용하는 경우
- `memberService` `itemService` 가 모두 빈으로 등록된다
```java
@Slf4j
@SpringBootTest
public class ServiceTestV1 {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void test() {
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isNotNull();

        ItemService itemService = applicationContext.getBean("itemService", ItemService.class);
        assertThat(itemService).isNotNull();

        applicationContextInfo();
    }

    private void applicationContextInfo() {
        int beanCount = applicationContext.getBeanDefinitionCount();
        log.info("beanCount={}", beanCount);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanNames)
                .forEach(beanName -> {
                    log.info("beanName={} bean={}", beanName, applicationContext.getBean(beanName).getClass());
                });
    }
}
```
```bash
# console

beanCount=135
beanName=org.springframework.boot.test.mock.mockito.MockitoPostProcessor$SpyPostProcessor bean=class org.springframework.boot.test.mock.mockito.MockitoPostProcessor$SpyPostProcessor
beanName=org.springframework.boot.test.mock.mockito.MockitoPostProcessor bean=class org.springframework.boot.test.mock.mockito.MockitoPostProcessor
beanName=org.springframework.context.annotation.internalConfigurationAnnotationProcessor bean=class org.springframework.context.annotation.ConfigurationClassPostProcessor
beanName=org.springframework.context.annotation.internalAutowiredAnnotationProcessor bean=class org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
beanName=org.springframework.context.annotation.internalCommonAnnotationProcessor bean=class org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
beanName=org.springframework.context.event.internalEventListenerProcessor bean=class org.springframework.context.event.EventListenerMethodProcessor
beanName=org.springframework.context.event.internalEventListenerFactory bean=class org.springframework.context.event.DefaultEventListenerFactory
beanName=springBootTestAnnotationTestApplication bean=class study.springboottestannotationtest.SpringBootTestAnnotationTestApplication$$EnhancerBySpringCGLIB$$8121a4b3
beanName=org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory bean=class org.springframework.boot.type.classreading.ConcurrentReferenceCachingMetadataReaderFactory

beanName=itemService bean=class study.springboottestannotationtest.service.ItemService
beanName=memberService bean=class study.springboottestannotationtest.service.MemberService

beanName=org.springframework.boot.autoconfigure.AutoConfigurationPackages bean=class org.springframework.boot.autoconfigure.AutoConfigurationPackages$BasePackages
beanName=org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration bean=class org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration
beanName=propertySourcesPlaceholderConfigurer bean=class org.springframework.context.support.PropertySourcesPlaceholderConfigurer
beanName=org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration bean=class org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration
beanName=websocketServletWebServerCustomizer bean=class org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer
beanName=org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration bean=class org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration
beanName=org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat bean=class org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat
beanName=tomcatServletWebServerFactory bean=class org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
beanName=org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration
beanName=servletWebServerFactoryCustomizer bean=class org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer
beanName=tomcatServletWebServerFactoryCustomizer bean=class org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer
beanName=org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor bean=class org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor
beanName=org.springframework.boot.context.internalConfigurationPropertiesBinderFactory bean=class org.springframework.boot.context.properties.ConfigurationPropertiesBinder$Factory
beanName=org.springframework.boot.context.internalConfigurationPropertiesBinder bean=class org.springframework.boot.context.properties.ConfigurationPropertiesBinder
beanName=org.springframework.boot.context.properties.BoundConfigurationProperties bean=class org.springframework.boot.context.properties.BoundConfigurationProperties
beanName=org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.methodValidationExcludeFilter bean=class org.springframework.boot.validation.beanvalidation.MethodValidationExcludeFilter$$Lambda$814/0x0000000800496440
beanName=server-org.springframework.boot.autoconfigure.web.ServerProperties bean=class org.springframework.boot.autoconfigure.web.ServerProperties
beanName=webServerFactoryCustomizerBeanPostProcessor bean=class org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor
beanName=errorPageRegistrarBeanPostProcessor bean=class org.springframework.boot.web.server.ErrorPageRegistrarBeanPostProcessor
beanName=org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration
beanName=dispatcherServlet bean=class org.springframework.web.servlet.DispatcherServlet
beanName=spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties bean=class org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties
beanName=org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration
beanName=dispatcherServletRegistration bean=class org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean
beanName=org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration
beanName=org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration bean=class org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration
beanName=taskExecutorBuilder bean=class org.springframework.boot.task.TaskExecutorBuilder
beanName=applicationTaskExecutor bean=class org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
beanName=spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties bean=class org.springframework.boot.autoconfigure.task.TaskExecutionProperties
beanName=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration
beanName=error bean=class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$StaticView
beanName=beanNameViewResolver bean=class org.springframework.web.servlet.view.BeanNameViewResolver
beanName=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration
beanName=conventionErrorViewResolver bean=class org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver
beanName=spring.web-org.springframework.boot.autoconfigure.web.WebProperties bean=class org.springframework.boot.autoconfigure.web.WebProperties
beanName=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
beanName=errorAttributes bean=class org.springframework.boot.web.servlet.error.DefaultErrorAttributes
beanName=basicErrorController bean=class org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController
beanName=errorPageCustomizer bean=class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$ErrorPageCustomizer
beanName=preserveErrorControllerTargetClassPostProcessor bean=class org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$PreserveErrorControllerTargetClassPostProcessor
beanName=org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration
beanName=requestMappingHandlerAdapter bean=class org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter
beanName=welcomePageHandlerMapping bean=class org.springframework.boot.autoconfigure.web.servlet.WelcomePageHandlerMapping
beanName=localeResolver bean=class org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
beanName=themeResolver bean=class org.springframework.web.servlet.theme.FixedThemeResolver
beanName=flashMapManager bean=class org.springframework.web.servlet.support.SessionFlashMapManager
beanName=mvcConversionService bean=class org.springframework.boot.autoconfigure.web.format.WebConversionService
beanName=mvcValidator bean=class org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport$NoOpValidator
beanName=mvcContentNegotiationManager bean=class org.springframework.web.accept.ContentNegotiationManager
beanName=requestMappingHandlerMapping bean=class org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
beanName=mvcPatternParser bean=class org.springframework.web.util.pattern.PathPatternParser
beanName=mvcUrlPathHelper bean=class org.springframework.web.util.UrlPathHelper
beanName=mvcPathMatcher bean=class org.springframework.util.AntPathMatcher
beanName=viewControllerHandlerMapping bean=class org.springframework.beans.factory.support.NullBean
beanName=beanNameHandlerMapping bean=class org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping
beanName=routerFunctionMapping bean=class org.springframework.web.servlet.function.support.RouterFunctionMapping
beanName=resourceHandlerMapping bean=class org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
beanName=mvcResourceUrlProvider bean=class org.springframework.web.servlet.resource.ResourceUrlProvider
beanName=defaultServletHandlerMapping bean=class org.springframework.beans.factory.support.NullBean
beanName=handlerFunctionAdapter bean=class org.springframework.web.servlet.function.support.HandlerFunctionAdapter
beanName=mvcUriComponentsContributor bean=class org.springframework.web.method.support.CompositeUriComponentsContributor
beanName=httpRequestHandlerAdapter bean=class org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter
beanName=simpleControllerHandlerAdapter bean=class org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter
beanName=handlerExceptionResolver bean=class org.springframework.web.servlet.handler.HandlerExceptionResolverComposite
beanName=mvcViewResolver bean=class org.springframework.web.servlet.view.ViewResolverComposite
beanName=mvcHandlerMappingIntrospector bean=class org.springframework.web.servlet.handler.HandlerMappingIntrospector
beanName=viewNameTranslator bean=class org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator
beanName=org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter bean=class org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter
beanName=defaultViewResolver bean=class org.springframework.web.servlet.view.InternalResourceViewResolver
beanName=viewResolver bean=class org.springframework.web.servlet.view.ContentNegotiatingViewResolver
beanName=requestContextFilter bean=class org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter
beanName=org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
beanName=formContentFilter bean=class org.springframework.boot.web.servlet.filter.OrderedFormContentFilter
beanName=org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration bean=class org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration
beanName=forceAutoProxyCreatorToUseClassProxying bean=class org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$ClassProxyingConfiguration$$Lambda$666/0x000000080042c440
beanName=org.springframework.boot.autoconfigure.aop.AopAutoConfiguration bean=class org.springframework.boot.autoconfigure.aop.AopAutoConfiguration
beanName=org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration bean=class org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration
beanName=applicationAvailability bean=class org.springframework.boot.availability.ApplicationAvailabilityBean
beanName=org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration bean=class org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration
beanName=standardJacksonObjectMapperBuilderCustomizer bean=class org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration$StandardJackson2ObjectMapperBuilderCustomizer
beanName=spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties bean=class org.springframework.boot.autoconfigure.jackson.JacksonProperties
beanName=org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration bean=class org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration
beanName=jacksonObjectMapperBuilder bean=class org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
beanName=org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration bean=class org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration
beanName=parameterNamesModule bean=class com.fasterxml.jackson.module.paramnames.ParameterNamesModule
beanName=org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration bean=class org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration
beanName=jacksonObjectMapper bean=class com.fasterxml.jackson.databind.ObjectMapper
beanName=org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration bean=class org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
beanName=jsonComponentModule bean=class org.springframework.boot.jackson.JsonComponentModule
beanName=jsonMixinModule bean=class org.springframework.boot.jackson.JsonMixinModule
beanName=org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration bean=class org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration
beanName=org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration bean=class org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration
beanName=lifecycleProcessor bean=class org.springframework.context.support.DefaultLifecycleProcessor
beanName=spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties bean=class org.springframework.boot.autoconfigure.context.LifecycleProperties
beanName=org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration bean=class org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration
beanName=stringHttpMessageConverter bean=class org.springframework.http.converter.StringHttpMessageConverter
beanName=org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration bean=class org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration
beanName=mappingJackson2HttpMessageConverter bean=class org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
beanName=org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration bean=class org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration
beanName=org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration bean=class org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration
beanName=messageConverters bean=class org.springframework.boot.autoconfigure.http.HttpMessageConverters
beanName=org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration bean=class org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration
beanName=spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties bean=class org.springframework.boot.autoconfigure.info.ProjectInfoProperties
beanName=org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration bean=class org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration
beanName=spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties bean=class org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties
beanName=org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor bean=class org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor
beanName=org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration bean=class org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration
beanName=scheduledBeanLazyInitializationExcludeFilter bean=class org.springframework.boot.autoconfigure.task.ScheduledBeanLazyInitializationExcludeFilter
beanName=taskSchedulerBuilder bean=class org.springframework.boot.task.TaskSchedulerBuilder
beanName=spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties bean=class org.springframework.boot.autoconfigure.task.TaskSchedulingProperties
beanName=org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration
beanName=restTemplateBuilderConfigurer bean=class org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer
beanName=restTemplateBuilder bean=class org.springframework.boot.web.client.RestTemplateBuilder
beanName=org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration bean=class org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration
beanName=tomcatWebServerFactoryCustomizer bean=class org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer
beanName=org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration
beanName=org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration
beanName=characterEncodingFilter bean=class org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter
beanName=localeCharsetMappingsCustomizer bean=class org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration$LocaleCharsetMappingsCustomizer
beanName=org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration bean=class org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration
beanName=multipartConfigElement bean=class javax.servlet.MultipartConfigElement
beanName=multipartResolver bean=class org.springframework.web.multipart.support.StandardServletMultipartResolver
beanName=spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties bean=class org.springframework.boot.autoconfigure.web.servlet.MultipartProperties
beanName=org.springframework.aop.config.internalAutoProxyCreator bean=class org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator
```

## ServiceTest2
- `@SpringBootTest` 에 `(classes = {MemberService.class})` 를 등록하면
- `memberService` 만 빈으로 등록되고
- `itemService` 빈으로 등록되지 않는다
```java
@Slf4j
@SpringBootTest(classes = {MemberService.class})
public class ServiceTestV2 {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void test() {
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isNotNull();

        assertThatThrownBy(() -> {
            ItemService itemService = applicationContext.getBean("itemService", ItemService.class);
        }).isInstanceOf(NoSuchBeanDefinitionException.class);

        applicationContextInfo();
    }

    private void applicationContextInfo() {
        int beanCount = applicationContext.getBeanDefinitionCount();
        log.info("beanCount={}", beanCount);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanNames)
                .forEach(beanName -> {
                    log.info("beanName={} bean={}", beanName, applicationContext.getBean(beanName).getClass());
                });
    }
}
```
```bash
# console

beanCount=9
beanName=org.springframework.boot.test.mock.mockito.MockitoPostProcessor$SpyPostProcessor bean=class org.springframework.boot.test.mock.mockito.MockitoPostProcessor$SpyPostProcessor
beanName=org.springframework.boot.test.mock.mockito.MockitoPostProcessor bean=class org.springframework.boot.test.mock.mockito.MockitoPostProcessor
beanName=org.springframework.context.annotation.internalConfigurationAnnotationProcessor bean=class org.springframework.context.annotation.ConfigurationClassPostProcessor
beanName=org.springframework.context.annotation.internalAutowiredAnnotationProcessor bean=class org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
beanName=org.springframework.context.annotation.internalCommonAnnotationProcessor bean=class org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
beanName=org.springframework.context.event.internalEventListenerProcessor bean=class org.springframework.context.event.EventListenerMethodProcessor
beanName=org.springframework.context.event.internalEventListenerFactory bean=class org.springframework.context.event.DefaultEventListenerFactory

beanName=memberService bean=class study.springboottestannotationtest.service.MemberService

beanName=org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory bean=class org.springframework.boot.type.classreading.ConcurrentReferenceCachingMetadataReaderFactory
```
