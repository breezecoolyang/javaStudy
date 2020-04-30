package com.example.springtest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ComponentTest {


    @Value("1")
    private long name;
    public static void output() {
        System.out.println("output");
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }
}
