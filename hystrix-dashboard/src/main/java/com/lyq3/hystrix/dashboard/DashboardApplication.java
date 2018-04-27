package com.lyq3.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 卡卢比
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class DashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class,args);
    }
}
