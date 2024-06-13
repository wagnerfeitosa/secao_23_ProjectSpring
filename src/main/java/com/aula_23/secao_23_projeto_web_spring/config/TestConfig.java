package com.aula_23.secao_23_projeto_web_spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aula_23.secao_23_projeto_web_spring.entities.Category;
import com.aula_23.secao_23_projeto_web_spring.entities.Order;
import com.aula_23.secao_23_projeto_web_spring.entities.OrderItem;
import com.aula_23.secao_23_projeto_web_spring.entities.Product;
import com.aula_23.secao_23_projeto_web_spring.entities.User;
import com.aula_23.secao_23_projeto_web_spring.enums.OrderStatus;
import com.aula_23.secao_23_projeto_web_spring.repositories.CategoryRepository;
import com.aula_23.secao_23_projeto_web_spring.repositories.OrderItemRepository;
import com.aula_23.secao_23_projeto_web_spring.repositories.OrderRepository;
import com.aula_23.secao_23_projeto_web_spring.repositories.ProductRepository;
import com.aula_23.secao_23_projeto_web_spring.repositories.UserRepository;
/*Essa classe TestConfig é nada mais que uma classe auxiliar que irá fazer
 *as configurações da aplicação essa é uma platica muito utilizada
 *@Configuration diz que é uma classe de configuração
 *@Profile("test") diz que é uma configuração especifica para o perfil de test;
 Class TestConfig serve para fazer um database seeding
 ou seja para popular o banco com alguns objetos*/

@Configuration
@Profile("test")
/*Para que possa executar quando o programa for executado
 * há muitas forma no caso foi implementado CommandLineRunner
 * que contém um metodo void run*/
public class TestConfig implements CommandLineRunner {
	
	/*@Autowired é para que o spring possa resolver a denpendecia
	 * e associar uma instancia o UserRepository no TestConfig*/
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;
 
	//O que for implementado no run será executado quando iniciar o programa
	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null,"Electronics");
		Category c2 = new Category(null,"Books");
		Category c3 = new Category(null,"Computer");
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		/*ASSOCIAÇOES
		 * acessando coleção categories da classe product e adicionando category*/
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		//salvando navamnete na base de dados
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null,"Maria Brown","maria@gmail.com","98547885","12345");
		User u2 = new User(null,"Alex green","alex@gmail.com","547888","36547");
		
		                                        //Formato ISO 8601 padrao UTC
		Order o1 = new Order(null,Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null,Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null,Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT,u1);
		
		
		/*salvando na base de dados*/
		//categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		//productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
		OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
	}
	

}
