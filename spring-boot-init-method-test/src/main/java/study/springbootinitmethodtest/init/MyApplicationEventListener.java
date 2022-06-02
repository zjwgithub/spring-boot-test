package study.springbootinitmethodtest.init;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationEventListener {
    
    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        System.out.println("  MyApplicationEventListener.applicationReady");
    }
}
