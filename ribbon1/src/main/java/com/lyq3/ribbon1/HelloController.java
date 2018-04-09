package com.lyq3.ribbon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public String test2(){
        return service.hiService();
    }
}
