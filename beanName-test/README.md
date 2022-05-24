
```java
// beanName= controllerA    bean= class study.beannametest.app.ControllerA

@Controller
public class ControllerA {
}
```
```java
// beanName= myControllerB  bean= class study.beannametest.app.ControllerB

@Controller("myControllerB")
public class ControllerB {
}
```
```java
public class ServiceA {
}
public class ServiceB {
}
public class ServiceC {
}
```
```java
@Configuration
public class MyConfig {

    // beanName= serviceA       bean= class study.beannametest.app.ServiceA
    @Bean
    public ServiceA serviceA() {
        return new ServiceA();
    }

    // beanName= myServiceB     bean= class study.beannametest.app.ServiceB
    @Bean
    public ServiceB myServiceB() {
        return new ServiceB();
    }

    // beanName= my_ServiceC    bean= class study.beannametest.app.ServiceC
    @Bean("my_ServiceC")
    public ServiceC myServiceC() {
        return new ServiceC();
    }
}
```
```
MyApplicationRunner.run
  beanName= controllerA    bean= class study.beannametest.app.ControllerA
  beanName= myControllerB  bean= class study.beannametest.app.ControllerB
  beanName= serviceA       bean= class study.beannametest.app.ServiceA
  beanName= myServiceB     bean= class study.beannametest.app.ServiceB
  beanName= my_ServiceC    bean= class study.beannametest.app.ServiceC
```
