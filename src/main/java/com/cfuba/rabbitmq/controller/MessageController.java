package com.cfuba.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfuba.dto.Item;
import com.cfuba.rabbitmq.AddedMessage;

@RestController
@RequestMapping(value = "/")
public class MessageController {

	@Autowired
	AddedMessage addedMessage;
	
	@GetMapping(value= "/addMessage")
	public String addMessage(){
		addedMessage.addMessage();
		return "Message Added!!";
	}
	
	@GetMapping(value= "/addItemMessage")
	public String addItemMessage(){
		addedMessage.addItemDataAsMessage(new Item(1, "CPU 32 gb", 21_000d, "CPU with 32 gb ram"));
		return "Message Added!!";
	}
	
	@GetMapping(value= "/health")
	public String checkHealth(){
		return "up!!";
	}
}
