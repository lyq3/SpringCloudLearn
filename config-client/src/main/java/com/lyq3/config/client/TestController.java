package com.lyq3.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${info.profile}")
    private String from ;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

}
