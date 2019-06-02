package com.segmentfault.spring.cloud.lesson8.web.controller;

import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = DemoRestController.class)
public class DemoRestControllerAdvice {

	@ExceptionHandler(TimeoutException.class)
	public Object faultToleranceTimeout(Throwable throwable) {
		return throwable.getMessage();
	}
}
