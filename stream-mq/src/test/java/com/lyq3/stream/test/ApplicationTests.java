package com.lyq3.stream.test;

import com.lyq3.mqtest.Sender;
import com.lyq3.StreamApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = StreamApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@EnableBinding(value = {ApplicationTests.SinkSender.class})
public class ApplicationTests {

    @Autowired
    private Sender sender;

    @Autowired
    private SinkSender sinkSender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }
    @Test
    public void test1(){
        sinkSender.output().send(MessageBuilder.withPayload("测试MQ").build());
    }

    public interface SinkSender {

        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();

    }

}
