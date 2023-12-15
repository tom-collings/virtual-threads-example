package com.example.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    
    private int counter = 0;

    @GetMapping ("/count")
    public int getCount() {
        System.out.println("something");
        return counter++;
        
    }

}
