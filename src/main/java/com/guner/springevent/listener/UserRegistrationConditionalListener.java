package com.guner.springevent.listener;

import com.guner.springevent.event.UserRegistrationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserRegistrationConditionalListener {

    @EventListener(condition = "#event.username.startsWith('admin')")
    public void handleAdminRegistrationEvent(UserRegistrationEvent event) {
        log.debug("Waiting some time in thread : {}", Thread.currentThread().getName() );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.debug("User created with username : {}", event.getUsername());
    }
}