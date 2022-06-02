package study.applicationeventtest.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MyApplicationEventListener {
    
    private final ApplicationContext applicationContext;

    @EventListener(ApplicationEvent.class)
    public void applicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationEventListener.applicationEvent, event=" + event.getClass());
    }

    @EventListener(ApplicationContextInitializedEvent.class)
    public void applicationContextInitializedEvent() {
        System.out.println("MyApplicationEventListener.applicationContextInitializedEvent");
    }

    @EventListener(ApplicationEnvironmentPreparedEvent.class)
    public void applicationEnvironmentPreparedEvent() {
        System.out.println("MyApplicationEventListener.applicationEnvironmentPreparedEvent");
    }

    @EventListener(ApplicationFailedEvent.class)
    public void applicationFailedEvent() {
        System.out.println("MyApplicationEventListener.applicationFailedEvent");
    }

    @EventListener(ApplicationPreparedEvent.class)
    public void applicationPreparedEvent() {
        System.out.println("MyApplicationEventListener.applicationPreparedEvent");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyEvent() {
        System.out.println("MyApplicationEventListener.applicationReadyEvent");
        System.out.println("applicationContext = " + applicationContext);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void applicationStartedEvent() {
        System.out.println("MyApplicationEventListener.applicationStartedEvent");
    }

    @EventListener(ApplicationStartingEvent.class)
    public void applicationStartingEvent() {
        System.out.println("MyApplicationEventListener.applicationStartingEvent");
    }

    @EventListener(ApplicationContextEvent.class)
    public void applicationContextEvent() {
        System.out.println("MyApplicationEventListener.applicationContextEvent");
    }

    @EventListener(ContextStartedEvent.class)
    public void contextStartedEvent() {
        System.out.println("MyApplicationEventListener.contextStartedEvent");
    }
    
    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        System.out.println("MyApplicationEventListener.contextRefreshedEvent");
    }
}
