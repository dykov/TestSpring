package com.dykov.spring.testproject.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String message;
    private Date date;
    private DateFormat dateFormat;


    public Event(Date date, DateFormat df) {
        this.id = new Random().nextInt(100) + 1;
        this.date = date;
        this.dateFormat = df;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", date=" + dateFormat.format(date) +
                "}\r\n";
    }

}
