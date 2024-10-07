package com.guner.springevent.service;

import com.guner.springevent.event.UserRegistrationEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationService {

    private final ApplicationEventPublisher eventPublisher;
    //private TransactionalApplicationEventPublisher transactionalApplicationEventPublisher;

    public void registerUser(String username) {
        // ... registration logic ...
        log.debug("UserRegistrationService.registerUser() called with: username = [{}]", username);

        eventPublisher.publishEvent(new UserRegistrationEvent(this, username));
    }

    //@Transactional
    public void registerUserTransactional(String username) {
        // ... registration logic ...

        //transactionalApplicationEventPublisher.publishEvent(new UserRegistrationEvent(this, username));
    }
}