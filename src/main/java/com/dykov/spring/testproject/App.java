package com.dykov.spring.testproject;

import com.dykov.spring.testproject.beans.Client;
import com.dykov.spring.testproject.beans.Event;
import com.dykov.spring.testproject.beans.EventType;
import com.dykov.spring.testproject.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger logger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = logger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event event, String msg) {
        String message = msg.replaceAll(
                String.valueOf(client.getId()), client.getName()
        );
        event.setMessage(message);

        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean("app", App.class);

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Event INFO: user 100");

        event = (Event) context.getBean("event");
        app.logEvent(EventType.ERROR, event, "Event ERROR: user 100");

        event = (Event) context.getBean("event");
        app.logEvent(null, event, "Event default: user 100");

        context.close();
    }
}
