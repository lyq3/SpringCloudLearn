package com.lyq3.feign1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("client1")
public interface TestFeignClient {
    @GetMapping("/test")
    String consumer();
}
