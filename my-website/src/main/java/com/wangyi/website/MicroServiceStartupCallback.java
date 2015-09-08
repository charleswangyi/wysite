package com.wangyi.website;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class MicroServiceStartupCallback implements
                                        ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initializeApplication();
    }
    
    private void initializeApplication() {
        //initial data here
    }
}
