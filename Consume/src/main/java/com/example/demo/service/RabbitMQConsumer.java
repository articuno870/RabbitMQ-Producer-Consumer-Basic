package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${user.queue}")
	public void receivedMessage(Employee employee) {
		System.out.println(employee);
	}
}
