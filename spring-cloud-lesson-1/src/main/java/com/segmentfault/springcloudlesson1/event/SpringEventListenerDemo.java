package com.segmentfault.springcloudlesson1.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class SpringEventListenerDemo {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyApplicationListener.class);
		
//		context.addApplicationListener(new MyApplicationListener());
//		//启动上下文
//		context.refresh();
//		
		context.publishEvent(new MyApplicationEvent("Hello,World"));
		context.publishEvent(new MyApplicationEvent(1));
	    context.publishEvent(new MyApplicationEvent(new Double(1.0)));

	}
	
	@Component
	public static class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

		@Override
		public void onApplicationEvent(ApplicationEvent event) {
            System.out.printf("MyApplicationListener receives event source : %s \n", event.getSource());
            System.out.printf("MyApplicationListener receives event source : %s \n", event.getClass());


		}
		
	}
	public static class MyApplicationEvent extends ApplicationEvent {

		public MyApplicationEvent(Object source) {
			super(source);
		}
		
	}

}
