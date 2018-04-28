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
        int i = 0;
        //这里发送消息到队列，SinkReceiver监听到后就会打印输出（消费）
        for(;;i++){
            sinkSender.output().send(MessageBuilder.withPayload("测试MQ"+i).build());
        }
    }

    /**
     * 这里的input名和SinkReceiver里的input名组成发布订阅关系，一个输入(SubscribableChannel)一个输出(MessageChannel)
     */
    public interface SinkSender {

        String OUTPUT = "input";

        @Output(SinkSender.OUTPUT)
        MessageChannel output();

    }

}
