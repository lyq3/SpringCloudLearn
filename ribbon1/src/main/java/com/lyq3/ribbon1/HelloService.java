package com.lyq3.ribbon1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService() {
        return restTemplate.getForObject("http://client1/test",String.class);
    }

}
