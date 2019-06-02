package com.segumentfault.spring.cloud.lesson7.user.service.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.segumentfault.spring.cloud.lesson7.api.UserService;
import com.segumentfault.spring.cloud.lesson7.domain.User;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserServiceProviderController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public boolean user(@RequestBody User user){
        return userService.saveUser(user);
    }
    
    @HystrixCommand(
    		commandProperties = {
    		@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")
    		},
    		fallbackMethod = "fallbackForGetUsers"
    		)
    @GetMapping("/user/all")
    public Collection<User> findAll(){
        return userService.findAll();
    }

    public Collection<User> fallbackForGetUsers() {
    	 return new ArrayList<>();
    }
}
