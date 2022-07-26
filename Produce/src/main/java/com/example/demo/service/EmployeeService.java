package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${user.exchange}")
	private String exchangeName;

	@Value("${user.queue}")
	private String queueName;

	@Value("${user.routingkey}")
	private String routingKey;

	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(exchangeName, routingKey, employee);
		System.out.println("Message sent: " + employee);
	}

}
