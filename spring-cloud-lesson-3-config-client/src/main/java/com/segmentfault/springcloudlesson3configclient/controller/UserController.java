package com.segmentfault.springcloudlesson3configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.segmentfault.springcloudlesson3configclient.domain.User;

@RestController
@EnableConfigurationProperties(User.class)
public class UserController {

	private  final User user;
	
	 @Autowired
	public UserController(User user) {
	        this.user = user; 
	 }
	 
	 @GetMapping("/user")
	    public User user() {
	        return user;
	    }
	
}
