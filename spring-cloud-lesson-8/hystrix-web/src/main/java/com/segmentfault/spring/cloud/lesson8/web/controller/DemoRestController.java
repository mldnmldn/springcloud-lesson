package com.segmentfault.spring.cloud.lesson8.web.controller;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	
	 private final static Random random = new Random();
	 
	 /**
	  * 方法执行时间超过100秒，触发异常
	  * @return
	  * @throws Exception
	  */
	 @GetMapping("")
	 public String index() throws Exception {
		 
		 long executeTime = random.nextInt(200);
		 
		 if(executeTime > 100) {
			 throw new TimeoutException("");
		 }
		 return "Hello,World";
	 }
}
