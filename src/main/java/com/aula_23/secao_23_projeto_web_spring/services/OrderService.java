package com.aula_23.secao_23_projeto_web_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula_23.secao_23_projeto_web_spring.entities.Order;
import com.aula_23.secao_23_projeto_web_spring.repositories.OrderRepository;

@Service
public class OrderService  {
	
	
	@Autowired
	private OrderRepository userRepository;
	
	public List<Order> findAll(){
		return userRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = userRepository.findById(id);
		return obj.get();
	}

}
