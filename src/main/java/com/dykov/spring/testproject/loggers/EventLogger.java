package com.dykov.spring.testproject.loggers;

import com.dykov.spring.testproject.beans.Event;

public interface EventLogger {
    void logEvent(Event event);
}
