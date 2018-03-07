package com.lyq3.client1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/test")
    public String test1(){
        return port;
    }
}
