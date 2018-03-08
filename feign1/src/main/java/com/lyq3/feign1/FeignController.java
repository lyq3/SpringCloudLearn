package com.lyq3.feign1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private TestFeignClient client;
    @RequestMapping("/feign_test")
    public String test(){
        return client.consumer();
    }

}
