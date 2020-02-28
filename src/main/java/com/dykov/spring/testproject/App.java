package com.dykov.spring.testproject;

import com.dykov.spring.testproject.beans.Client;
import com.dykov.spring.testproject.beans.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger logger;

    public App(Client client, EventLogger logger) {
        this.client = client;
        this.logger = logger;
    }

    public void logEvent(String msg) {
        String message = msg.replaceAll(
                String.valueOf(client.getId()), client.getName()
        );
        logger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean("app", App.class);
        app.logEvent("Hello, user 100");

        ((ConfigurableApplicationContext) context).close();
    }
}
