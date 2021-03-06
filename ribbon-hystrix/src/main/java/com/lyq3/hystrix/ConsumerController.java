package com.lyq3.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String test() {
        return consumerService.hiService();
    }
}
