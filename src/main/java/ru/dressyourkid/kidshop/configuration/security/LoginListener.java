package ru.dressyourkid.kidshop.configuration.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * Created by lconnected on 01/08/2018.
 */
@Component
public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        // todo handle authenticated event
    }

}
