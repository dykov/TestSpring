package com.dykov.spring.testproject.loggers;

import com.dykov.spring.testproject.beans.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
