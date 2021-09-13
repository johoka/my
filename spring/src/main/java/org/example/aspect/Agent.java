package org.example.aspect;

import org.springframework.stereotype.Component;

@Component
public class Agent {

    public String test(){
        System.out.println("test...");
        return "ok";
    }
}
