package com.dykov.spring.testproject;

import com.dykov.spring.testproject.beans.Client;
import com.dykov.spring.testproject.beans.Event;
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

    public void logEvent(Event event, String msg) {
        String message = msg.replaceAll(
                String.valueOf(client.getId()), client.getName()
        );
        event.setMessage(message);
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean("app", App.class);

        Event event = context.getBean(Event.class);
        app.logEvent(event, "Hello, user 100");

        event = context.getBean(Event.class);
        app.logEvent(event, "Hi, user 100");

        ((ConfigurableApplicationContext) context).close();
    }
}
