package com.lyq3.client1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test1(){
        return "123123213";
    }
}
