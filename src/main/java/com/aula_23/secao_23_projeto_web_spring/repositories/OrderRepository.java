package com.aula_23.secao_23_projeto_web_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula_23.secao_23_projeto_web_spring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
