package com.dykov.spring.testproject.loggers;

import com.dykov.spring.testproject.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (EventLogger l : loggers) {
            l.logEvent(event);
        }
    }
}
