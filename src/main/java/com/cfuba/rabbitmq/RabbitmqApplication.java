package com.cfuba.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqApplication {

	public static final String EXCHANGE_NAME = "default-exchange";
	public static final String QUEUE1 = "5001";
	public static final String QUEUE2 = "5002";
	public static final String ROUTING_KEY1 = "5001";
	public static final String ROUTING_KEY2 = "5002";

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

	@Bean
	public Queue getQueue1() {
		return new Queue(QUEUE1, Boolean.FALSE);
	}

	@Bean
	public Queue getQueue2() {
		return new Queue(QUEUE2, Boolean.FALSE);
	}

	@Bean
	public TopicExchange getTopicExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Binding doBinding1(@Qualifier("getQueue1") Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY1);

	}

	@Bean
	public Binding doBinding2(@Qualifier("getQueue2") Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY2);

	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE1,QUEUE2);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

}
