package com.segumentfault.spring.cloud.lesson7.user.ribbon.client;

import com.netflix.loadbalancer.IRule;
import com.segumentfault.spring.cloud.lesson7.user.ribbon.client.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RibbonClient("user-service-provider") // 指定目标应用名称
public class UserRibbonClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRibbonClientApplication.class, args);
    }
    @Bean
    public IRule myRule() {
        return new MyRule();
    }


}
