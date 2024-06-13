package com.aula_23.secao_23_projeto_web_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula_23.secao_23_projeto_web_spring.entities.OrderItem;
import com.aula_23.secao_23_projeto_web_spring.entities.pk.OrderItemPk;

/*JpaRepository contém toda a implementação CRUD 
 * ao criar essa interface que extends JpaRepository náo é necessario
 * criar a implementação para a interface,pois o JpaReposytory
 * contém todos os metodos para monipular dados  na base de dados*/

//@Repository não é necessario pois ela herda JpaRepository que já está registrada 
public interface OrderItemRepository extends JpaRepository<OrderItem,OrderItemPk>{
		

}
