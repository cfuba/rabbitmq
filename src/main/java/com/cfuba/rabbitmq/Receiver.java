package com.cfuba.rabbitmq;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

	public void receiveMessage(String message){
		System.out.println("Message Received. "+ message);
	}
	
	public void receiveMessage(Object message){
		System.out.println("Object Message Received. "+ message);
	}
}
