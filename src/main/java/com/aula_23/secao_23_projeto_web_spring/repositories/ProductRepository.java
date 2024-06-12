package com.aula_23.secao_23_projeto_web_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula_23.secao_23_projeto_web_spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
