package com.example.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping
    public String helloWorld(){
        return "Hello world from spring boot";
    }
    //Alt+Shift+F10 to run
    @RequestMapping("/goodbye")
    public String goodbay(){
        return "Bye Byeeee";
    }
}
