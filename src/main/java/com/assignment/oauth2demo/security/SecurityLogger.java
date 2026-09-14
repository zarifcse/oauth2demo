package com.assignment.oauth2demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class SecurityLogger {

    private static final Logger logger = LoggerFactory.getLogger(SecurityLogger.class);

    @EventListener
    public void onLoginSuccess(AuthenticationSuccessEvent event) {
        logger.info("Successful user login: {}", event.getAuthentication().getName());
    }

    @EventListener
    public void onLoginFailure(AbstractAuthenticationFailureEvent event) {
        logger.error("Failed authentication attempt: {}", event.getException().getMessage());
    }
}