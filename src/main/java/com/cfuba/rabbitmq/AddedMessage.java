package com.cfuba.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfuba.dto.Item;

@Service
public class AddedMessage {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void addMessage(){
		rabbitTemplate.convertAndSend(RabbitmqApplication.EXCHANGE_NAME, RabbitmqApplication.ROUTING_KEY1, "Hello from RabbitMQ!");
		System.out.println("Message Sent!!");
	}
	
	public void addItemDataAsMessage(Item item){
		rabbitTemplate.convertAndSend(RabbitmqApplication.EXCHANGE_NAME, RabbitmqApplication.ROUTING_KEY2, item);
		System.out.println("Message Sent!!");
	}
}
