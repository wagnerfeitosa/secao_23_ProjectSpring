package com.aula_23.secao_23_projeto_web_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula_23.secao_23_projeto_web_spring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
