package com.segmentfault.springcloudlesson3configclient;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;
@SpringBootApplication
public class SpringCloudLesson3ConfigClientApplication {
	
	@Autowired
	private ContextRefresher contextRefresher;
	
	@Scheduled(fixedRate =1000L)
	public void update() {
		Set<String> keys = contextRefresher.refresh();
        if (!keys.isEmpty()) {
            System.out.println("本次更新的配置项: " + keys);
        }
	}
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLesson3ConfigClientApplication.class, args);
    }

}
