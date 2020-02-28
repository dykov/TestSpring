package com.dykov.spring.testproject.beans;

public class Client {
    private int id;
    private String name;
    private String greeting;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
